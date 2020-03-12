class Bahnhof{

    Stack<Integer> a, b, c;
    public Bahnhof(){
        a = new Stack<Integer>();
        b = new Stack<Integer>();
        c = new Stack<Integer>();
        a.push(16);
        a.push(11);
        a.push(15);
        a.push(14);
        this.rangiere(a, b, c);
        this.ausgabe(c);
    }

    public void ausgabe(Stack<Integer> s){
        Stack<Integer> copy = s;
        while(!copy.isEmpty()){
            System.out.print(copy.top() + " ");
            copy.pop();
        }
    }

    public void rangiere(Stack<Integer> a, Stack<Integer> b, Stack<Integer> c){
        //solange das Startgleis nicht leer ist
        while(!a.isEmpty()){
            //Solange (Wagennummer im Ziel kleiner als Wagennummer am Start) oder (Zielgleis leer)
            int vorneC = 0;
            int vorneA = a.top();
            if(!c.isEmpty()) vorneC = c.top();
            while(vorneA > vorneC){
                //Fahre vom Startgleis ins Zielgleis
                c.push(a.top());
                a.pop();
                vorneC = c.top();
                if(a.isEmpty()){
                    break;
                } else {
                vorneA = a.top();
                }
            }
            //Solange Startgleis nicht leer und Wagennummer im Ziel größer ist als am Start
            while(!a.isEmpty() && vorneC > vorneA){
                //Fahre Wagen vom Zielgleis aufs Abstellgleis
                b.push(c.top());
                c.pop();
                if(!c.isEmpty()) vorneC = c.top();
                else vorneC = 0;
            }

            //Fahre den richtigen Wagen vom Startgleis aufs Zielgleis
            c.push(a.top());
            a.pop();
        }

            //Wenn Abstellgleis nicht leer ist tausche die Funktionen von Start- und Abstellgleis
            if(!b.isEmpty()) this.rangiere(b, a, c);
        
    }

    public static void main(String[] args) {
        new Bahnhof();
    }

}