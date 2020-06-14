# Sign Template is a JavaFX application 🔐


 `Status: Complete !!🦦`


This program can be used by any JavaFx programs that require a **Sign up/Sign in** page

<h2> What does the program do? </h2>

This program stores the user's info into a file and it would use it later to check if the user exists (Basically a sign up/sign in page)

<h2>Example of a successful sign up / sign in ✅</h2>  


<p align="center">
<img src="https://github.com/ashMohseni/Login/blob/master/src/resources/success3.gif?raw=true" alt="successful signup/signin" width="90%" height="70%">
</p>




<h2>Example of a unsuccessful sign up / sign in ❌</h2> 

<p align="center">
<img src="https://github.com/ashMohseni/Login/blob/master/src/resources/error1-3.gif?raw=true" alt="errorr 1" width="90%" height="70%">
</p>
  
<p align="center">
<img src="https://github.com/ashMohseni/Login/blob/master/src/resources/error2-3.gif?raw=true" alt="error 2" width="90%" height="70%">
</p>

<h2>A bit more details about this program..👨‍💻</h2>

 
As I've mentioned before, once the user **inputs** their information, the application would then **store/write** that information to a file so we could have access to it at any time. Then the next step is **reading** and **writing back** those very pieces of information to a **hashMap**, designed to store the username(**key**) and it's password(**value**), so once a user wants to sign in, we could easily **approve** its username and password. In another word, it would be easy to apply the proper **exceptions** to it. Also when signing up, I've coded some **regex** to make sure the entered values are correct and as the **standards**.


<h2> How to setup </h2>

<p align="center">
<img src="https://github.com/ashMohseni/Login/blob/master/src/resources/instruction%202.gif?raw=true" alt="instructions" width="90%" height="70%">
</p>

**Step1:** Download the JavaFx **SDK** from [here](https://gluonhq.com/products/javafx/)!

**Step2:** Add the SDK to your **libraries** in your IDE

**Step3:** From project propperties go to `Libraries/Compile` and add the JavaFx library to the **`Classpath`**

**Step4:** From project propperties go to `Libraries/Run` and add the JavaFx library to the **`Modulepath`**

**Step5:** Add the following to your **VM Options** : `--add-modules javafx.controls,javafx.fxml,javafx.graphics`

**Step6:** Check off the `Compile on Save` option and **you're good to go**!!☺️

