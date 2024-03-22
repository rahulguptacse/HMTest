Feature: Search Engine

Scenario Outline: Verify car search
  Given for a car reg for '<input>' and '<output>'
  Then user car search the vehicle
  Examples:
  |input|output|
  |input_1|output_1|