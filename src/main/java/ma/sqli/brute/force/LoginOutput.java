package ma.sqli.brute.force;

public class LoginOutput {
    private StringBuilder out=new StringBuilder();

    LoginOutput plus(String out){
        if(this.out.length()==0){
            this.out.append(out);
        }else{
            this.out.append(" - "+out);
        }
        return this;
    }

    @Override
    public String toString() {
        return out.toString();
    }
}
