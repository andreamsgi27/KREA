import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SolicitudCRUD {
    private Connection connection;

    public SolicitudCRUD(String jdbcUrl, String dbUser, String dbPassword) throws SQLException {
        this.connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);
    }

    // Crear una nueva solicitud (Create)
    public void crearSolicitud(Solicitud solicitud) throws SQLException {
        String query = "INSERT INTO solicitudes (nombre_solicitud, fecha_solicitud, tema_solicitud, descripcion_solicitud, estado_solicitud) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, solicitud.getNombreSolicitud());
        statement.setString(2, solicitud.getFechaSolicitud());
        statement.setString(3, solicitud.getTemaSolicitud());
        statement.setString(4, solicitud.getDescripcionSolicitud());
        statement.setString(5, solicitud.getEstadoSolicitud());
        statement.executeUpdate();
        statement.close();
    }

    // Leer una solicitud por su ID (Read)
    public Solicitud obtenerSolicitud(int id) throws SQLException {
        String query = "SELECT * FROM solicitudes WHERE solicitud_id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            Solicitud solicitud = new Solicitud(
                resultSet.getInt("solicitud_id"),
                resultSet.getString("nombre_solicitud"),
                resultSet.getString("fecha_solicitud"),
                resultSet.getString("tema_solicitud"),
                resultSet.getString("descripcion_solicitud"),
                resultSet.getString("estado_solicitud")
            );
            resultSet.close();
            statement.close();
            return solicitud;
        } else {
            resultSet.close();
            statement.close();
            return null; // No se encontró la solicitud
        }
    }

    // Actualizar una solicitud (Update)
    public void actualizarSolicitud(Solicitud solicitud) throws SQLException {
        String query = "UPDATE solicitudes SET nombre_solicitud = ?, fecha_solicitud = ?, tema_solicitud = ?, descripcion_solicitud = ?, estado_solicitud = ? WHERE solicitud_id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, solicitud.getNombreSolicitud());
        statement.setString(2, solicitud.getFechaSolicitud());
        statement.setString(3, solicitud.getTemaSolicitud());
        statement.setString(4, solicitud.getDescripcionSolicitud());
        statement.setString(5, solicitud.getEstadoSolicitud());
        statement.setInt(6, solicitud.getSolicitudId());
        statement.executeUpdate();
        statement.close();
    }

    // Eliminar una solicitud (Delete)
    public void eliminarSolicitud(int id) throws SQLException {
        String query = "DELETE FROM solicitudes WHERE solicitud_id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        statement.executeUpdate();
        statement.close();
    }

    // Listar todas las solicitudes (Read all)
    public List<Solicitud> listarSolicitudes() throws SQLException {
        List<Solicitud> solicitudes = new ArrayList<>();
        String query = "SELECT * FROM solicitudes";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            Solicitud solicitud = new Solicitud(
                resultSet.getInt("solicitud_id"),
                resultSet.getString("nombre_solicitud"),
                resultSet.getString("fecha_solicitud"),
                resultSet.getString("tema_solicitud"),
                resultSet.getString("descripcion_solicitud"),
                resultSet.getString("estado_solicitud")
            );
            solicitudes.add(solicitud);
        }

        resultSet.close();
        statement.close();
        return solicitudes;
    }

    // Cerrar la conexión a la base de datos
    public void cerrarConexion() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
