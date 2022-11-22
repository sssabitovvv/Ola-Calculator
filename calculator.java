class calculator {
    public static void main(String[] args) {
        String input=System.console().readLine();
        if(input.length()>0) {
            //parser
            int a=-1;
            int b=-1;
            int c=-1;
            char frst=';';
            char scnd=';';
            char[] eq=input.toCharArray();
            int numcounter=0;
            boolean first=false;
            for(int i=0;i< eq.length;i++) {
                if (eq[i] > '0' && eq[i] <= '9') {
                    if (numcounter == 2) {
                        c = eq[i] - 48;
                    }
                    if (numcounter == 1) {
                        b = eq[i] - 48;
                        numcounter++;
                    }
                    if (numcounter == 0) {
                        a = eq[i] - 48;
                        numcounter++;
                    }
                }
                if (eq[i] == '+' || eq[i] == '*' || eq[i] == '/' || eq[i] == '-') {
                    if (first) {
                        scnd = eq[i];
                    } else {
                        frst = eq[i];
                        first = true;
                    }
                }
                if (eq[i] == '0') {
                    if (numcounter == 3) {
                        c = 10;
                    }
                    if (numcounter == 2) {
                        b = 10;
                    }
                    if (numcounter == 1) {
                        a = 10;
                    }
                }
            }
            //parser
            //equation
            if (frst==';'){
                throw new RuntimeException("not proper arithmetic symbol");
            }
            if(a==-1||b==-1) throw new RuntimeException("not proper numbers");
            int res=-1;
            if(c==-1 && scnd==';'){
                if(frst=='+')res=a+b;
                if(frst=='-')res=a-b;
                if(frst=='/')res=a/b;
                if(frst=='*') res=a*b;
            }else{
                if((scnd=='*'||scnd=='/')&&(frst=='-'||frst=='+')){
                    if(scnd=='/')res=b/c;
                    if(scnd=='*') res=b*c;
                    if(frst=='+')res=a+res;
                    if(frst=='-')res=a-res;
                }else {
                    if(frst=='+')res=a+b;
                    if(frst=='-')res=a-b;
                    if(frst=='/')res=a/b;
                    if(frst=='*') res=a*b;
                    if(scnd=='+')res+=c;
                    if(scnd=='-')res-=c;
                    if(scnd=='/')res/=b;
                    if(scnd=='*') res*=b;
                }
                if(res==-1){
                    throw new RuntimeException("exception");
                }
                System.out.print(res);
            }
            //equation

        }
        }
        }

