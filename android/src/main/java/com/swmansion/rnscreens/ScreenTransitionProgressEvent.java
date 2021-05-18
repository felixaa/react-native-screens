package com.swmansion.rnscreens;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class ScreenTransitionProgressEvent extends Event<ScreenAppearEvent> {

  public static final String EVENT_NAME = "topTransitionProgress";

  private final float mProgress;
  private final boolean mClosing;
  public ScreenTransitionProgressEvent(int viewId, float progress, boolean closing) {
    super(viewId);
    mProgress = progress;
    mClosing = closing;
  }

  @Override
  public String getEventName() {
    return EVENT_NAME;
  }

  @Override
  public short getCoalescingKey() {
    // All events for a given view can be coalesced.
    return 0;
  }

  @Override
  public void dispatch(RCTEventEmitter rctEventEmitter) {
    WritableMap map = Arguments.createMap();
    map.putDouble("progress", mProgress);
    map.putBoolean("closing", mClosing);
    rctEventEmitter.receiveEvent(getViewTag(), getEventName(), map);
  }
}