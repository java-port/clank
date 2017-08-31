/**
 * This file was converted to Java from the original LLVM source file. The original
 * source file follows the LLVM Release License, outlined below.
 * 
 * ==============================================================================
 * LLVM Release License
 * ==============================================================================
 * University of Illinois/NCSA
 * Open Source License
 * 
 * Copyright (c) 2003-2017 University of Illinois at Urbana-Champaign.
 * All rights reserved.
 * 
 * Developed by:
 * 
 *     LLVM Team
 * 
 *     University of Illinois at Urbana-Champaign
 * 
 *     http://llvm.org
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal with
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 * 
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimers.
 * 
 *     * Redistributions in binary form must reproduce the above copyright notice
 *       this list of conditions and the following disclaimers in the
 *       documentation and/or other materials provided with the distribution.
 * 
 *     * Neither the names of the LLVM Team, University of Illinois at
 *       Urbana-Champaign, nor the names of its contributors may be used to
 *       endorse or promote products derived from this Software without specific
 *       prior written permission.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS WITH THE
 * SOFTWARE.
 * 
 * ==============================================================================
 * Copyrights and Licenses for Third Party Software Distributed with LLVM:
 * ==============================================================================
 * The LLVM software contains code written by third parties.  Such software will
 * have its own individual LICENSE.TXT file in the directory in which it appears.
 * This file will describe the copyrights, license, and restrictions which apply
 * to that code.
 * 
 * The disclaimer of warranty in the University of Illinois Open Source License
 * applies to all code in the LLVM Distribution, and nothing in any of the
 * other licenses gives permission to use the names of the LLVM Team or the
 * University of Illinois to endorse or promote products derived from this
 * Software.
 * 
 * The following pieces of software have additional or alternate copyrights,
 * licenses, and/or restrictions:
 * 
 * Program             Directory
 * -------             ---------
 * Autoconf            llvm/autoconf
 *                     llvm/projects/ModuleMaker/autoconf
 * Google Test         llvm/utils/unittest/googletest
 * OpenBSD regex       llvm/lib/Support/{reg*, COPYRIGHT.regex}
 * pyyaml tests        llvm/test/YAMLParser/{*.data, LICENSE.TXT}
 * ARM contributions   llvm/lib/Target/ARM/LICENSE.TXT
 * md5 contributions   llvm/lib/Support/MD5.cpp llvm/include/llvm/Support/MD5.h
 */
package org.clank.support.aliases;

import org.clank.support.Converted;
import org.clank.support.NativeTrace;
import static org.clank.support.NativeType.*;


//<editor-fold defaultstate="collapsed" desc="template">
@Converted(kind = Converted.Kind.DUMMY, source = "${SPUTNIK}/modules/org.clank.java/src/org/clank/support/aliases/templates/memimpl.tpl")
//</editor-fold>
public final class bool$mem implements bool$memory {
    
    private final boolean[] array;

    public bool$mem(boolean value) {
        array = new boolean[1];
        array[0] = value;
    }

    public bool$mem(boolean[] array) {
        this.array = array;
    }

    @Override
    public boolean $set(int index, boolean value) {
        assert NativeTrace.assertArrayHasMutableContent(array, this);
        return array[(int)index] = value;
    }

    @Override
    public boolean $set$andassign(int index, boolean value) {
        assert NativeTrace.assertArrayHasMutableContent(array, this);
        return array[(int)index] &= value;
    }

    @Override
    public boolean $set$xorassign(int index, boolean value) {
        assert NativeTrace.assertArrayHasMutableContent(array, this);
        return array[(int)index] ^= value;
    }

    @Override
    public boolean $set$orassign(int index, boolean value) {
        assert NativeTrace.assertArrayHasMutableContent(array, this);
        return array[(int)index] |= value;
    }

    /*

    @Override
    public boolean $set$addassign(int index, boolean value) {
        assert NativeTrace.assertArrayHasMutableContent(array, this);
        return array[(int)index] += value;
    }

    @Override
    public boolean $set$minusassign(int index, boolean value) {
        assert NativeTrace.assertArrayHasMutableContent(array, this);
        return array[(int)index] -= value;
    }

    @Override
    public boolean $set$starassign(int index, boolean value) {
        assert NativeTrace.assertArrayHasMutableContent(array, this);
        return array[(int)index] *= value;
    }

    @Override
    public boolean $set$slashassign(int index, boolean value) {
        assert NativeTrace.assertArrayHasMutableContent(array, this);
        return array[(int)index] /= value;
    }

    @Override
    public boolean $set$modassign(int index, boolean value) {
        assert NativeTrace.assertArrayHasMutableContent(array, this);
        return array[(int)index] %= value;
    }

    @Override
    public boolean $set$lshiftassign(int index, boolean value) {
        assert NativeTrace.assertArrayHasMutableContent(array, this);
        return array[(int)index] <<= value;
    }

    @Override
    public boolean $set$rshiftassign(int index, boolean value) {
        assert NativeTrace.assertArrayHasMutableContent(array, this);
        return array[(int)index] >>= value;
    }

    @Override
    public boolean $set$postInc(int index) {
        assert NativeTrace.assertArrayHasMutableContent(array, this);
        return array[(int)index]++;
    }

    @Override
    public boolean $set$postDec(int index) {
        assert NativeTrace.assertArrayHasMutableContent(array, this);
        return array[(int)index]--;
    }

    @Override
    public boolean $set$preInc(int index) {
        assert NativeTrace.assertArrayHasMutableContent(array, this);
        return ++array[(int)index];
    }

    @Override
    public boolean $set$preDec(int index) {
        assert NativeTrace.assertArrayHasMutableContent(array, this);
        return --array[(int)index];
    }

    */

    @Override
    public boolean $at(int index) {
        return array[(int)index];
    }

    @Override
    public int sizeof() {
      return BYTES_IN_BOOL;
    }
    
    @Override
    public int size() {
        return array == null ? 0 : array.length;
    }
    
    @Override
    public int toByteIndex(int index) {
        return index * sizeof();
    }

    @Override
    public int fromByteIndex(int index) {
        return index / sizeof();
    }        

    @Override
    public boolean $eq(org.clank.support.NativeMemory.memory other) {
      if (this == other) {
        return true;
      } else if (other instanceof bool$mem) {
        return this.array == ((bool$mem) other).array;
      } else {
        return false;
      }
    }
    
    public boolean[] $array() {
        return array;
    }
}