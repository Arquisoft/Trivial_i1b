package es.uniovi.seti.Model;

import java.util.List;

public class TrivialQuestion {
  
  private String question; 
  
  private List<String> answers;
  
  private int positionTrue;
  
  public TrivialQuestion(String question, List<String> answers, int positionTrue){
      this.question = question;
      this.answers = answers;
      this.positionTrue = positionTrue;
  }
  
  public String getQuestion(){
    return this.question;
  }
  
  public List<String> getAnswers(){
    return this.answers;
  }
  
  public int getPositionTrue(){
    return this.positionTrue;
  }
  
}
