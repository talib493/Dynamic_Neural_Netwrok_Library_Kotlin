# Neural Network Library — Kotlin

This project started as a small experiment: building a neural network in Kotlin that could solve the XOR problem without relying on an existing machine learning library.

Over time, I expanded it into a more flexible neural network library where the network architecture, training process, activation functions, and error functions can be configured instead of being hardcoded for a single problem.

The entire implementation is written in Kotlin, including the mathematical classes used internally. I wanted to understand how the pieces fit together, so I built the core components from scratch rather than using an existing neural network framework.

## Features

- **Built from scratch:** The neural network implementation and its supporting mathematical classes are written in Kotlin.
- **Configurable network architecture:** Define the network's layers, input sizes, and neuron counts.
- **Dynamic training:** Configure the network for different datasets instead of being limited to a fixed XOR solver.
- **Multiple activation functions:** Choose from the activation functions implemented in the library.
- **Multiple error functions:** Use different error functions during training.
- **Custom mathematical classes:** Includes `Vector.kt` and `Matrix.kt`, implemented as part of the library.
- **Backpropagation:** Calculate output and hidden-layer deltas to support network training.
- **XOR support:** The original use case that started the project.
- **Iris dataset validation:** Tested the implementation on the Iris dataset and cross-checked the results.

## Tech Stack

- **Kotlin** — The entire library is written in Kotlin.
- **Custom vector and matrix operations** — Mathematical operations implemented for the neural network.
- **Neural network implementation from scratch** — No existing neural network framework is used for the core implementation.

## How the Project Evolved

### 1. A fixed XOR solver

The initial version was designed specifically to solve XOR. Its network configuration and training setup were built around that particular problem.

It was a useful starting point for understanding the fundamentals of neural networks and implementing the required calculations in code.

### 2. Dynamic configuration and training

I then worked on removing those fixed assumptions. The library evolved to support configurable network architectures and training, along with additional activation and error functions.

This made it possible to experiment with different configurations and apply the same implementation to problems beyond XOR.

### 3. Testing with the Iris dataset

After expanding the library, I tested it on the Iris dataset and cross-checked the results.

This was an important step because it moved the project beyond a small logical problem and helped verify that the implementation could also be used for a more involved classification task.

## The Mathematics Behind It

Rather than relying on an existing machine learning framework for the core operations, I implemented the supporting mathematical classes myself.

Some of the important components include:

- **`Vector.kt`** — Represents vectors and provides mathematical operations required by the network.
- **`Matrix.kt`** — Implements matrix operations used in neural network calculations.
- **Network layers** — Hold the neurons, weights, and activation functions used by the network.
- **Activation functions** — Determine how neuron outputs are calculated.
- **Error functions** — Measure the difference between predictions and target values.
- **Dynamic delta calculation** — Calculates output and hidden-layer deltas used during backpropagation.

These components form the foundation of the neural network implementation and allow the library to be configured for different problems.

## Example: Configuring a Network for Iris

One of the main goals of this project was to move beyond a network hardcoded for XOR and make the architecture configurable for different problems.

For example, the following network is configured for the Iris classification dataset, which contains four input features and three output classes.

```kotlin
val network = NeuralNetwork(
    layers = listOf(
        Layer(
            noOfInput = 4,
            noOfNeuron = 8,
            activationFunction = Sigmoid
        ),
        Layer(
            noOfInput = 8,
            noOfNeuron = 6,
            activationFunction = Sigmoid
        ),
        Layer(
            noOfInput = 6,
            noOfNeuron = 3,
            activationFunction = Sigmoid
        )
    )
)

val irisData = loadIrisDataset("iris.data")
```

### Feeding Data into the Network

Each Iris sample contains four input features and a target vector representing one of three classes: Setosa, Versicolor, or Virginica.

The input and target vectors are used during training. The network processes the input through its configured layers, calculates prediction errors, and propagates deltas backward through the network to support weight updates.

After training, the network can be used to predict the class of an input sample.

The example above demonstrates the network configuration and dataset loading. The actual training loop depends on the training functions provided by the library.

### Validation

I tested the implementation against the Iris dataset and cross-checked the results to verify that the library could learn a classification problem beyond the original XOR use case.

## Using the Library in an Android Project

I also integrated this library into my Android project, **Neural Network Playground**, where users can create, train, test, and inspect models through a Jetpack Compose interface.

The Android app currently focuses on four logical datasets: XOR, AND, NAND, and OR. The library is maintained as a separate project so that its underlying implementation can evolve independently of the app.

## Why I Built It

I wanted to go beyond using a machine learning API and understand what happens underneath. Building the mathematical operations and neural network implementation myself gave me a way to explore the calculations, training process, and configuration of a neural network directly in Kotlin.

What began as a fixed XOR solver gradually became a configurable library that I could test on more complex data, including Iris.

