package com.example.boterprojectjunior.service.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
    public class BotListItem {
        public int id;
        public String function_name;
        public String details;

        public BotListItem(int id, String function_name, String details) {
            this.id = id;
            this.function_name=function_name;
            this.details = details;
        }

        @Override
        public String toString() {
            return function_name;
        }
    }