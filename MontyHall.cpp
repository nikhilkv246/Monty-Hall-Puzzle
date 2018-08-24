Master change
$$$$$$$$$$$$$$$$$$

Develop change
$$$$$$$$$$$$$$$$$$

Feature 1 change
$$$$$$$$$$$$$$$$$$

#include <iostream>
#include <fstream>
#include <iomanip>
#include <ctime>
#include <cstdlib>

using namespace std;
typedef int Door;

const int SIMULATION_COUNT = 100;

/**
 * Suggested problem decomposition.
 * You do not have to use these function declarations.
 */

//Function Declarations
Door hideCar();
Door openDoor(Door firstChoiceDoor, Door carBehindDoor);
Door makeFirstChoice();
Door makeSecondChoice(Door firstDoor, Door openedDoor);
void simulate(int sequence, int& win1, int& win2);
void printHeader();

/**
 * Main
 */
int main()
{
    int win1 = 0, win2 = 0;

    srand(time(NULL));  // seed the random number generator
    printHeader();

    // Run the simulations.
    for (int i = 1; i <= SIMULATION_COUNT; i++) simulate(i, win1, win2);

    cout << endl;
    cout << setw(4) << win1 << " wins if stay with the first choice" << endl;
    cout << setw(4) << win2 << " wins if switch to the second choice" << endl;

    cout.setf(ios::fixed);
    cout.setf(ios::showpoint);
    cout.precision(1);

    cout << endl;
    cout << "Win ratio of switch over stay: ";
    cout << static_cast<double>(win2)/win1 << endl;
}

/***** Complete this program. ****/

//Function Definitions
Door hideCar()
{
	  Door carBehindDoor = rand()%3 + 1;
	  return carBehindDoor;

}

Door makeFirstChoice()
{
    Door  firstChoiceDoor = rand()%3 + 1;
	return firstChoiceDoor;
}

Door openDoor(Door firstChoiceDoor, Door carBehindDoor)
{
	Door openedDoor;
	Door tempDoor = rand()%3 + 1;
	while((firstChoiceDoor == tempDoor)||(carBehindDoor == tempDoor))
	{
		tempDoor = rand()%3 + 1;
	}
	openedDoor = tempDoor;
	return openedDoor;


}



Door makeSecondChoice(Door firstDoor, Door openedDoor)
{

	Door secondChoice;
	Door tempDoor = rand()%3 + 1;
		while((openedDoor == tempDoor)||(firstDoor == tempDoor))
		{
			tempDoor = rand()%3 + 1;
		}
	secondChoice = tempDoor;
	return secondChoice;


}


void simulate(int sequence, int& win1, int& win2)
{

	Door carBehindDoor = hideCar();
	Door firstChoiceDoor = makeFirstChoice();
	Door openedDoor = openDoor(firstChoiceDoor,carBehindDoor);
	Door secondChoice = makeSecondChoice(firstChoiceDoor,openedDoor);


   string w1 ="";
   string w2 ="";
   
   if (firstChoiceDoor== carBehindDoor)
		{
			win1++;
			w1 = "Yes";

		}
	else if (secondChoice == carBehindDoor)
		{
			win2++;
			w2 = "Yes";
		}
		

	cout << sequence<<"\t"<< carBehindDoor <<"\t" <<firstChoiceDoor<<"\t"<<openedDoor<<"\t"<<secondChoice<<"\t"<<w1<<"\t"<<w2<<"\t"<<endl;
}

void printHeader()
{

	cout << "#""\t"<< "Car""\t" <<"First""\t"<<"Opened""\t"<<"Second""\t"<<"Win""\t"<<"Win""\t"<<endl;
	cout << " ""\t"<< "Here""\t" <<"Choice""\t"<<"Door""\t"<<"Choice""\t"<<"First""\t"<<"Second""\t"<<endl;

}
