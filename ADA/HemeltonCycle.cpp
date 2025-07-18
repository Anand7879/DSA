#include <iostream>
using namespace std;
#define MAX 100

int G[MAX][MAX]; 
int X[MAX];     
int n;         


void Nextval(int k) {
    while (true) {
        X[k] = (X[k] + 1) % (n + 1);

        if (X[k] == 0)
            return; 

    
        if (G[X[k - 1]][X[k]] != 0) {
            bool alreadyInPath = false;
            for (int j = 1; j < k; j++) {
                if (X[j] == X[k]) {
                    alreadyInPath = true;
                    break;
                }
            }

            if (!alreadyInPath) {
               
                if (k < n || (k == n && G[X[n]][X[1]] == 1)) {
                    return; 
                }
            }
        }
    }
}


void Hamilton(int k) {
    while (true) {
        Nextval(k);

        if (X[k] == 0)
            return; 

        if (k == n) {
            for (int i = 1; i <= n; i++)
                cout << X[i] << " ";
            cout << X[1] << endl;
        } else {
            Hamilton(k + 1);
        }
    }
}

int main() {

    // n = 5; // Number of vertices

    // for (int i = 1; i <= n; i++)  
    //     for (int j = 1; j <= n; j++)
    //         G[i][j] = 0;

    // G[1][2] = G[2][1] = 1;
    // G[1][4] = G[4][1] = 1;
    // G[2][3] = G[3][2] = 1;
    // G[2][5] = G[5][2] = 1;
    // G[3][5] = G[5][3] = 1;
    // G[3][4] = G[4][3] = 1;



    n = 6;
     for (int i = 1; i <= n; i++)
        for (int j = 1; j <= n; j++)
            G[i][j] = 0;


    G[1][2] = G[2][1] = 1;
    G[1][3] = G[3][1] = 1;
    G[1][5] = G[5][1] = 1;
    G[2][3] = G[3][2] = 1;
    G[2][6] = G[6][2] = 1;
    G[3][4] = G[4][3] = 1;
    G[4][5] = G[5][4] = 1;
    G[5][6] = G[6][5] = 1;

   
    for (int i = 1; i <= n; i++)
        X[i] = 0;

    X[1] = 1; // Starting from vertex 1
    
    cout<<"\n";
    cout << "Hamiltonian cycles starting from vertex " << X[1] << ":\n";
    Hamilton(2);

    return 0;
}