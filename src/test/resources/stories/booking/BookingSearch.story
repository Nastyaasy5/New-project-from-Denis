Meta:
@Bug

Narrative:
In order to perform search correctly
As a user
I want to be able to see the list of found hotels, located in NY

Scenario: User should have possibility to see the list of found hotels, using own searching criterias

Given user has opened 'Booking.com' site

When user selects 'Destination' by using following values:
| destination                   | checkInDate |
| New York, New York State, USA | May 2018,22 |

And user cliks on 'Search' button

Then each item from 'Search Result' list contains '<searchResultValue>'

Examples:
| destinationValue              | checkInDateValue | searchResultValue |
| New York, New York State, USA | May 2018,22      | New York          |
| Majorca, Spain                | November 2017,10 | Majorca           |
