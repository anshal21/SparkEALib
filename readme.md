<h3>Project:</h3> Solving Problems with Genetic Algorithms using Spark.

<h3>Proposal:</h3> Designing and implementing a generalized framework with implementation of all kind of mutation and cross-over operation that are specific to all problems whose solution can be represented as -
A Vector of Doubles or Integers (Eg. finding waits of hidden units in Artificial Neural Network, Coefficient of terms in some equation )
A Permutation of Integers (Eg. Travelling Salesman problem. N-Queen Problem)

We will be designing a generalized framework that can use for any problem that can be represented in above formats. We will be running our algorithm parallel on different machines with different values of control parameters and finally select the most optimal solution of all.

As genetic algorithms involves randomness, so each algorithm run involves a probability of not reaching to an optimal solution. But if we are doing multiple runs with different control parameters then the probability of not reaching to a suboptimal solution by all the machine will be very less as compared to previous.  


<h1>SparkEALib Documentation :</h1>

<h2>Package Structure:</h2>

<h3>Source Package:</h3>
<ul>
<li>SparkEA</li>
<li>Selection</li>
<li>SparkGA</li>
<li>Binary Representation</li>
<li>Integer Representation</li>
<li>Permutation Representation</li> 
<li>ParallelizationEngine</li>

</ul>

<h3>Description of Classes:</h3>

<h3>SparkEA:</h3>

<b>Accessories:</b> Accessories is the common class between all type of representation which provides an interface to the user of library to provide an implementation of the “Fitness Function”

<b>Gene:</b> Gene is an abstract class for gene which is inherited by all different types of gene and some necessary functions are override-ed accordingly. E.g. getGene, setGene, loweBound, upperBound

<b>Chromosome:</b> Similar to Gene Chromosome is also a general class which contains signature and few implementation of all the necessary functions of a Chromosome and is inherited by all the Specific Chromosome like BinaryChromosome, IntegerChromosom etc. Contains the functions like getFitnessValue, getGene etc.

<b>Params:</b> Params is the General class for parameter settings of a Chromosome, this is inherited by all the specific Parameter classes and contains signature of some basic function and is mostly used for Run-Time Polymorphism to avoid repetition of Code.

<b>Utility:</b> As the name suggest this class contains most of the utility functions for example generating random probability in some give range, checking bounds, getting Fittest Chromosome among many etc.

<b>Work:</b> This is an interface which represents single working unit or we can say a single running implementation and contains signature of functions like fork, which we will describe later. 



<h4>SparkEA.Selection:</h4>

<b>SelectionMethods:</b> Contains the implementation of some fitness based selection methods like RouletteWheel , though more methods can be added by user or other contributors like rank or tournament based methods.

  
<h4>SparkEA.BinaryRepresentation:</h4>

<b>BinaryGene:</b> Contains the implementation of a BinaryGene which can have values 0 or 1, implementation of function from Generalized gene class and some Representation specific functions like setRandom etc.

<b>Parameters:</b> It inherits the base Params class and implement the abstract functions while having this representation specific attributes like . MutationProbability, CrossOverProbability, MutationProbabilityChangeRate etc.  

<b>BinaryChromsome:</b> Contains the array of BinaryGene, Object of Parameters and implementation of all the methods declared in the base Chromosome Class. In addition to these methods the class contains the Representation Specifc Mutation and Cross-Over function. Like for Binary Representation, uniformCrossover and RandomMutation.

<b>ParentSelection:</b> Class is used to select the parents for Crossover and uses the methods implemented in SelectionMethods class. 

<b>SurvivorSelection:</b> As the name suggest it used to select the next generation and also uses the methods define in SelectionMethdos.

<b>Solver:</b> Solver class provides the user an interface to provide their implementation of solution like choice of their mutation and crossover function, number of iterations etc. User overrides a function named solve which contain a list of Chromosome as parameter which is the initial population.

<b>Worker:</b>  It implements the Work interface and can be seen as single running unit of code. It contains function like fork, which is used to fork multiple similar working unit from one unit of code. It contains solve function which is called by the Spark Map function and which ultimately calls the function in the Solver class which contains the user’s implementation oe we can say definition of single unit.


<b>Note:</b> All the classes in Integer and Permutation Representation are analogous to Binary Representation while having representation specific function and Mutation and Crossovers.

<h4>ParallelizationEngine:</h4> 

<b>SimpleDistributor:</b> Creates a Spark Application and Replicates the single Worker unit provided by user using fork and then runs them and aggregates the results at the end and returns the Fittest Chromosome after aggregation.

<b>AdvanceDistributor:</b> Creates a Spark Application, Replicates the single Worker unit into many while updating their Parameters according to the change rates provided by user. Runs these worker units with different parameters in parallel and aggregates the result and returns the fittest Chromosome.

