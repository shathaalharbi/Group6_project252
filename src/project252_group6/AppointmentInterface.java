
package project252_group6;

public abstract class AppointmentInterface {
  abstract  public void service();
  
  abstract public void sendRequest();
  abstract public void reciveApproval();
  
  public void start(){
      sendRequest();
      reciveApproval();
  }
   
  
}
