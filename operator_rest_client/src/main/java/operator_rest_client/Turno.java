package operator_rest_client;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
public class Turno {
	@JsonProperty("numeroTurno")
	   private int numeroTurno;
	   @JsonProperty("creacion")
	   private List<Integer> creacion; // O usa int[] para un array
	   @JsonProperty("fechaHoraTurno")
	   private List<Integer> fechaHoraTurno; // También puedes cambiar este campo si es necesario
	   @JsonProperty("cuil")
	   private String cuil;
	   @JsonProperty("nombre")
	   private String nombre;
	   @JsonProperty("apellido")
	   private String apellido;
	   @JsonProperty("puestoAtencionAsignado")
	   private int puestoAtencionAsignado;
	   @JsonProperty("pendiente")
	   private int pendiente;
	   @JsonProperty("llamado")
	   private int llamado;
	   // Getters
	   public int getNumeroTurno() {
	       return numeroTurno;
	   }
	   public List<Integer> getCreacion() {
	       return creacion;
	   }
	   public List<Integer> getFechaHoraTurno() {
	       return fechaHoraTurno;
	   }
	   public String getCuil() {
	       return cuil;
	   }
	   public String getNombre() {
	       return nombre;
	   }
	   public String getApellido() {
	       return apellido;
	   }
	   public int getPuestoAtencionAsignado() {
	       return puestoAtencionAsignado;
	   }
	   public int getPendiente() {
	       return pendiente;
	   }
	   public int getLlamado() {
	       return llamado;
	   }
	   // Setters
	   public void setNumeroTurno(int numeroTurno) {
	       this.numeroTurno = numeroTurno;
	   }
	   public void setCreacion(List<Integer> creacion) {
	       this.creacion = creacion;
	   }
	   public void setFechaHoraTurno(List<Integer> fechaHoraTurno) {
	       this.fechaHoraTurno = fechaHoraTurno;
	   }
	   public void setCuil(String cuil) {
	       this.cuil = cuil;
	   }
	   public void setNombre(String nombre) {
	       this.nombre = nombre;
	   }
	   public void setApellido(String apellido) {
	       this.apellido = apellido;
	   }
	   public void setPuestoAtencionAsignado(int puestoAtencionAsignado) {
	       this.puestoAtencionAsignado = puestoAtencionAsignado;
	   }
	   public void setPendiente(int pendiente) {
	       this.pendiente = pendiente;
	   }
	   public void setLlamado(int llamado) {
	       this.llamado = llamado;
	   }


}