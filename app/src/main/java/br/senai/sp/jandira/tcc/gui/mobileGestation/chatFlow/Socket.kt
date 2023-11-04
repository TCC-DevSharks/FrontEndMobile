import io.socket.client.IO
import io.socket.client.Socket
import java.net.URISyntaxException
import android.util.Log
import org.json.JSONObject

class SocketManager {
    private var socket: Socket? = null

    init {
        try {
            socket = IO.socket("http://10.0.2.2:3000/")
//            handleMsgReceive { receivedMsg ->
//                // Faça algo com a mensagem recebida, por exemplo, exibir em algum lugar na interface do usuário.
//                Log.d("SocketManager", "Mensagem recebida: $receivedMsg")
//            }
        } catch (e: URISyntaxException) {
            Log.e("SocketManager", "Erro ao criar o socket: ${e.message}")
            e.printStackTrace()
        } catch (e: Exception) {
            Log.e("SocketManager", "Erro desconhecido: ${e.message}")
            e.printStackTrace()
        }
    }

    fun connect() {
        try {
            socket?.connect()
            Log.d("SocketManager", "Conectando ao servidor Socket.io...")
        }catch (e: Exception) {
            Log.e("SocketManager", "Erro desconhecido: ${e.message}")
            e.printStackTrace()
        }

    }

    fun disconnect() {
        socket?.disconnect()
        Log.d("SocketManager", "Desconectando do servidor Socket.io...")
    }

    fun addUser(user: String){
        Log.e("SocketManager", "$user")
        socket?.emit("add-user", user)
        Log.e("SocketManager", "Adicionando um usuario")

    }

    fun sendMsg(to: String, msg: String){
        try {
            val data = JSONObject()
            data.put("to", to)
            data.put("msg", msg)

            socket?.emit("send-msg", data)
            Log.e("SocketManager", "$data")
            Log.e("SocketManager", "Enviando mensagem")
        }catch (e: Exception) {
            Log.e("SocketManager", "Erro desconhecido: ${e.message}")
            e.printStackTrace()
        }

    }

    fun handleMsgReceive(callback: (String) -> Unit) {
        socket?.on("msg-receive") { args ->
            if (args.isNotEmpty()) {
                val receivedMsg = args[0].toString()
                callback(receivedMsg)
            }
        }
    }


}