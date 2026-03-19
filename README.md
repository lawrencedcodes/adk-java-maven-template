# Java ADK Agent Examples

This repository contains a collection of sample AI agents built using the [Google Agent Development Kit (ADK)](https://google.github.io/adk-docs/) for Java and Maven. These examples demonstrate various agent architectures, ranging from simple conversational LLMs to complex multi-agent workflows including Sequential, Parallel, and Loop agents.

## Included Agents

The `src/main/java/com/example/agent/` directory contains several distinct agent examples:

* **`CodeRefiner`**: Demonstrates a **LoopAgent** that iteratively writes and reviews Python code. It orchestrates a `code-generator` and a `code-reviewer` agent, running until the reviewer is satisfied, before passing the final output to a `final-presenter`.
* **`CompanyDetective`**: A comprehensive multi-agent setup using a **ParallelAgent** to independently research a company's profile, financial snapshot, and latest news using a Google Search tool. A **SequentialAgent** then pipes this data into a `report-compiler` to generate a polished market research report.
* **`HelloWeatherAgent`**: A fundamental agent showcasing how to bind custom Java methods as tools (`@Schema` and `FunctionTool`). It provides mock weather data based on user input and offers a custom CLI chat loop implementation out of the box.
* **`LocalNews`**: A simple, focused agent configured with the `GoogleSearchTool` to browse the web and act as a local news aggregator.
* **`PoetAndTranslator`**: Demonstrates a **SequentialAgent** pipeline chaining two specialized agents: one acts as a poet, and the other as an expert translator that translates the poem into French while retaining the rhymes.
* **`ScienceTeacher`**: A basic persona-driven **LlmAgent** that explains complex science concepts to teenagers in a simple, direct manner.
* **`StockTicker`**: An agent utilizing a custom `lookup_stock_ticker` Java function tool to retrieve mock stock prices directly from native Java code based on the ticker name logic.
* **`SupportAgent`**: Demonstrates a routing agent topology where a primary `support-agent` acts as a dispatcher to sub-agents (`order-agent` and `after-sale-agent`), properly delegating the user's prompt to the correct department.

## Prerequisites & Setup

1. **Java Development Kit:** Ensure you have **Java 17** or higher installed.
2. **Maven:** Ensure Apache Maven is installed to build and run the projects.
3. **API Key:** To use the default Gemini models, you must have a Google AI API key. You can get one from [Google AI Studio](https://aistudio.google.com/apikey).

Set up the required environment variables in your terminal before running the agents:

```shell
export GOOGLE_API_KEY="PASTE_YOUR_ACTUAL_API_KEY_HERE"
export GOOGLE_GENAI_USE_VERTEXAI=FALSE
```

## Running the Agents

Most agents in this project initialize the **ADK Dev UI**, providing a rich visual interface to test prompts and visualize the sub-agent architecture, tool calls, and execution steps.

To run a specific agent from the command line, use the `exec:java` Maven plugin and point it to the desired agent's main class.

**Example: Running the `CompanyDetective` agent**
```shell
mvn compile exec:java -Dexec.mainClass="com.example.agent.CompanyDetective"
```

Once the application starts, open your browser and navigate to:
**[http://localhost:8080/](http://localhost:8080/)**

From the Dev UI, select the agent in the top-left corner and interact with it in the chat panel.

*(Note: `HelloWeatherAgent` is configured by default to run in the terminal standard-input loop. Check its `main()` method to switch back to the ADK Dev UI if preferred).*

---

> [!NOTE]  
> This template project is a foundation for learning and building with Google's adk-java SDK. It is not an official Google product.