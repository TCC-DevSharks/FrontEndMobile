import io.socket.client.IO
import io.socket.client.Socket
import java.net.URISyntaxException
import android.util.Log

class SocketManager {
    private var socket: Socket? = null

    init {
        try {
            socket = IO.socket("http://10.0.2.2:3000/")
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
        socket?.emit("add-user", user)
        Log.e("SocketManager", "Adicionando um usuario")

    }

    // ...
}