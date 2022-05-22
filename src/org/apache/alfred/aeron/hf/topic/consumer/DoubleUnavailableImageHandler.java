/*******************************************************************************
 *
 *
 *  Copyright (c) 2022 Alfred
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 ******************************************************************************/

package org.apache.alfred.aeron.hf.topic.consumer;

import io.aeron.Image;
import io.aeron.UnavailableImageHandler;

/**
 * Allows to compose two {@link UnavailableImageHandler} into one.
 *
 * @author Alexei Osipov
 */
class DoubleUnavailableImageHandler implements UnavailableImageHandler {
    private final UnavailableImageHandler first;
    private final UnavailableImageHandler second;

    DoubleUnavailableImageHandler(UnavailableImageHandler first, UnavailableImageHandler second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public void onUnavailableImage(Image image) {
        first.onUnavailableImage(image);
        second.onUnavailableImage(image);
    }
}