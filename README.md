# Android-Timeline-Schedule-View
Timeline Schedule View Library (A view group like google calendar day view)

![alt text](https://github.com/r3za13/Android-Timeline-Schedule-View/blob/master/images/screenshot1.png?raw=true)
![alt text](https://github.com/r3za13/Android-Timeline-Schedule-View/blob/master/images/screenshot2.png?raw=true)

### Adding TimeLineLayout:

Add it in your root build.gradle at the end of repositories:
```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
Add the dependency
```
dependencies {
	implementation 'com.github.r3za13:android-timeline-schedule-view:0.9'
}
```

Adding widget:
```
<com.roundtableapps.timelinedayviewlibrary.TimeLineLayout
        android:id="@+id/timeLine"
        android:layout_width="wrap_content"
        android:layout_height="match_parent"
        android:background="#e14279"
        android:clipToPadding="false"
        android:paddingBottom="50dp"
        app:dividerColor="#55b7ff65"
        app:dividerTextColor="#FFF"
        app:eachRowHeight="25dp"
        app:minimumPercentage="0.25"
        app:numberOfRows="24"
        />
```
Add EventView to widget:
```
//MY EVENT IS A SAMPLE OBJECT THAT YOU CAN CREATE AND EXTEND IT FROM 'Event' class
var myEventView = EventView(this,
          MyEvent().apply {
          startTime = fromValue
          endTime = toValue
          },
          itemsMargin = 1, //optional
          layoutResourceId = R.layout.item_event_two, //optional
          setupView = { myView ->
                        //SETUP VIEW
                        myView.findViewById<TextView>(R.id.tvTitle).text = etTitle.text.toString()
                        },
                       onItemClick = { event ->
                        //CLICK EVENT
                       }
          )
          
timeLine.addEvent(myEventView)
                        
```
### Attributes

```
dividerColor 
dividerTextColor
eachRowHeight
minimumPercentage : minimum height percentage of cell (percentage of eachRowHeight)
numberOfRows
dividerTitles: string array of row names
dividerStartOffset: start offset of each row name
```
