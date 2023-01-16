# Issue

The issue looks to be the minimumSdk. Any version under 24 the app will crash (logs at the bottom).

## STR:

You can experiment with the crash by increasing the minSdk in both project and app .build.gradle files 
and building. 

Anything below SDK level 24 will crash, anything at level 24+ will run when the `id fullstory` plugin is applied and the
Block is added:

```groovy
fullstory {
    
}
```

You can also confirm the app builds fine when a min SDK version lower than 24 is set and you remove the `fullstory` block and applied plugin.

### Crash Log
```kotlin
FATAL EXCEPTION: main
                                                                                                    Process: io.daio.fullstorycompose, PID: 1449
                                                                                                    java.lang.IncompatibleClassChangeError: Found interface androidx.compose.ui.graphics.drawscope.DrawScope, but class was expected (declaration of 'androidx.compose.ui.graphics.drawscope.DrawScope' appears in /data/app/~~TsoLHRCn-jh2RSedehd0Ww==/io.daio.fullstorycompose-YIg5d9yaqIBT1PbYxiKEzQ==/base.apk)
                                                                                                    	at androidx.compose.ui.graphics.drawscope.DrawScope.drawRect-n-J9OG0$default(DrawScope.kt:410)
                                                                                                    	at androidx.compose.foundation.Background.drawRect(Background.kt:111)
                                                                                                    	at androidx.compose.foundation.Background.draw(Background.kt:103)
                                                                                                    	at androidx.compose.ui.node.BackwardsCompatNode.draw(BackwardsCompatNode.kt:381)
                                                                                                    	at androidx.compose.ui.node.LayoutNodeDrawScope.draw-x_KDEd0$ui_release(LayoutNodeDrawScope.kt:92)
                                                                                                    	at androidx.compose.ui.node.NodeCoordinator.drawContainedDrawModifiers(NodeCoordinator.kt:365)
                                                                                                    	at androidx.compose.ui.node.NodeCoordinator.draw(NodeCoordinator.kt:354)
                                                                                                    	at androidx.compose.ui.node.LayoutNode.draw$ui_release(LayoutNode.kt:827)
                                                                                                    	at androidx.compose.ui.node.InnerNodeCoordinator.performDraw(InnerNodeCoordinator.kt:151)
                                                                                                    	at androidx.compose.ui.node.NodeCoordinator.drawContainedDrawModifiers(NodeCoordinator.kt:362)
                                                                                                    	at androidx.compose.ui.node.NodeCoordinator.draw(NodeCoordinator.kt:354)
                                                                                                    	at androidx.compose.ui.node.LayoutModifierNodeCoordinator.performDraw(LayoutModifierNodeCoordinator.kt:236)
                                                                                                    	at androidx.compose.ui.node.NodeCoordinator.drawContainedDrawModifiers(NodeCoordinator.kt:362)
                                                                                                    	at androidx.compose.ui.node.NodeCoordinator.access$drawContainedDrawModifiers(NodeCoordinator.kt:58)
                                                                                                    	at androidx.compose.ui.node.NodeCoordinator$invoke$1.invoke(NodeCoordinator.kt:391)
                                                                                                    	at androidx.compose.ui.node.NodeCoordinator$invoke$1.invoke(NodeCoordinator.kt:390)
                                                                                                    	at androidx.compose.runtime.snapshots.Snapshot$Companion.observe(Snapshot.kt:2139)
                                                                                                    	at androidx.compose.runtime.snapshots.SnapshotStateObserver$observeReads$1$1.invoke(SnapshotStateObserver.kt:130)
                                                                                                    	at androidx.compose.runtime.snapshots.SnapshotStateObserver$observeReads$1$1.invoke(SnapshotStateObserver.kt:126)
                                                                                                    	at androidx.compose.runtime.SnapshotStateKt__DerivedStateKt.observeDerivedStateRecalculations(DerivedState.kt:341)
                                                                                                    	at androidx.compose.runtime.SnapshotStateKt.observeDerivedStateRecalculations(Unknown Source:1)
                                                                                                    	at androidx.compose.runtime.snapshots.SnapshotStateObserver.observeReads(SnapshotStateObserver.kt:126)
                                                                                                    	at androidx.compose.ui.node.OwnerSnapshotObserver.observeReads$ui_release(OwnerSnapshotObserver.kt:120)
                                                                                                    	at androidx.compose.ui.node.NodeCoordinator.invoke(NodeCoordinator.kt:390)
                                                                                                    	at androidx.compose.ui.node.NodeCoordinator.invoke(NodeCoordinator.kt:58)
                                                                                                    	at androidx.compose.ui.platform.RenderNodeApi29.record(RenderNodeApi29.android.kt:209)
                                                                                                    	at androidx.compose.ui.platform.RenderNodeLayer.updateDisplayList(RenderNodeLayer.android.kt:301)
                                                                                                    	at androidx.compose.ui.platform.RenderNodeLayer.drawLayer(RenderNodeLayer.android.kt:242)
                                                                                                    	at androidx.compose.ui.node.NodeCoordinator.draw(NodeCoordinator.kt:349)
                                                                                                    	at androidx.compose.ui.node.LayoutNode.draw$ui_release(LayoutNode.kt:827)
                                                                                                    	at androidx.compose.ui.node.InnerNodeCoordinator.performDraw(InnerNodeCoordinator.kt:151)
                                                                                                    	at androidx.compose.ui.node.NodeCoordinator.drawContainedDrawModifiers(NodeCoordinator.kt:362)
                                                                                                    	at androidx.compose.ui.node.NodeCoordinator.draw(NodeCoordinator.kt:354)
                                                                                                    	at androidx.compose.ui.node.LayoutNode.draw$ui_release(LayoutNode.kt:827)
                                                                                                    	at androidx.compose.ui.platform.AndroidComposeView.dispatchDraw(AndroidComposeView.android.kt:1036)
                                                                                                    	at android.view.View.draw(View.java:22647)
                                                                                                    	at android.view.View.updateDisplayListIfDirty(View.java:21519)
                                                                                                    	at android.view.View.draw(View.java:22375)
                                                                                                    	at android.view.ViewGroup.drawChild(ViewGroup.java:4528)
                                                                                                    	at android.view.ViewGroup.dispatchDraw(ViewGroup.java:4289)
                                                                                                    	at android.view.View.updateDisplayListIfDirty(View.java:21510)
                                                                                                    	at android.view.View.draw(View.java:22375)
                                                                                                    	at android.view.ViewGroup.drawChild(ViewGroup.java:4528)
                                                                                                    	at android.view.ViewGroup.dispatchDraw(ViewGroup.java:4289)
```