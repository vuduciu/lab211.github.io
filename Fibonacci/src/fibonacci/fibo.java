/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacci;

/**
 *
 * @author Admin
 */
public class fibo {
    private int n;

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
    public int fibonacci(int n){
        if(n < 2) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
