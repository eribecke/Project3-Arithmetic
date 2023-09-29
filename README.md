# Project4

This app is an arithmetic problem generator. The user can choose from a list of difficulties and operations to practice specific kinds of math problems.
There are only two different screens, the menu and the questions screen. 


## Functionality 

The following **required** functionality is completed:

* [ ] User sees options for difficulty and opertations, as well as incrementors/decrementors for choosing the number of problems.
* [ ] User can push start button to go to the next screen and solve math problems.
* [ ] User sees generated problems based off what they selected on the previous screen.
* [ ] User can enter their answers to each problem and push the done button to submit them.
* [ ] User will hear a sound that plays after each problem which corresponds to whether they get the question wrong or right
* [ ] User will see a toast appear after each problem which corresponds to whether they get the question wrong or right
* [ ] User will be taken back to the menu if they push the done button after the last problem.
* [ ] User will see their results displayed (#correct out of total number of questions) near the top of the menu screen, as well as a message that corresponds to their score
* [ ] User can enter new settings and start another quiz from the menu screen


## Video Walkthrough

Here's a walkthrough of implemented user stories:

![arithmeticApp2](https://github.com/eribecke/Project3-Arithmetic/assets/97013344/0d50582a-3613-48b3-93ff-7655f6f2cb91)


## Notes

My greatest challenge was passing the information from the question fragment back to the menu fragment. I had to set the default value of the results = "@null" and then check its value in the menu fragment. 

## License

    Copyright [2023] [Erika Becker]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
