public class OutroCodigoDoAluno {

    boolean isConsoante(String s, int i) {
        boolean resp = true;
        
        if (i < s.length()) {
            char p = Character.toUpperCase(s.charAt(i));
            
            if (p == 'A' || p == 'E' || p == 'I' || p == 'O' || p == 'U') {
                resp = false;
            } else {
                resp = isConsoante(s, i + 1);
            }
        }

        return resp;
    }
}
