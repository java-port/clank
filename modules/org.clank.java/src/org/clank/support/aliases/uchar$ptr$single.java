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

import org.clank.support.AbstractSinglePointerType;
import org.clank.support.Converted;
import org.clank.support.NativeTrace;

/**
 * Lightest implementation of pointer to byte
 */
//<editor-fold defaultstate="collapsed" desc="template">
@Converted(kind = Converted.Kind.DUMMY, source = "${SPUTNIK}/modules/org.clank.java/src/org/clank/support/aliases/templates/pointersingleimpl.tpl")
//</editor-fold>
public final class uchar$ptr$single extends AbstractSinglePointerType<uchar$ptr> implements uchar$ptr, uchar$ref {
    
    private byte val;

    public uchar$ptr$single() {
        this((byte)0);
    }
    
    public uchar$ptr$single(byte val) {
        this.val = val;
        trackInstance();
    }

    ////////////////////////////////////////////////////////////////////////////
    // common operations
    @Override
    public boolean $isNull() {
      return /*this pointer is never null*/false;
    }
  
    @Override
    public byte $deref() {
      return $star();
    }

    @Override
    public byte $star() {
      return val;
    }

    @Override
    public byte $set(byte value) {
        val = value;
        return val;
    }

    @Override
    public byte $at(int index) {
        if (index != 0) {
            throw new IllegalArgumentException("Index must be zero to access to the single variable!");
        }
        return val;
    }

    @Override
    public byte $set(int index, byte value) {
        if (index != 0) {
            throw new IllegalArgumentException("Index must be zero to access to the single variable!");
        }
        return this.val = value;
    }       
    
    @Override
    public byte $set$andassign(int index, byte value) {
        if (index != 0) {
            throw new IllegalArgumentException("Index must be zero to access to the single variable!");
        }
        return this.val &= value;
    }

    @Override
    public byte $set$andassign(byte value) {
        return this.val &= value;
    }

    @Override
    public byte $set$xorassign(int index, byte value) {
        if (index != 0) {
            throw new IllegalArgumentException("Index must be zero to access to the single variable!");
        }
        return this.val ^= value;
    }

    @Override
    public byte $set$xorassign(byte value) {
        return this.val ^= value;
    }

    @Override
    public byte $set$orassign(int index, byte value) {
        if (index != 0) {
            throw new IllegalArgumentException("Index must be zero to access to the single variable!");
        }
        return this.val |= value;
    }
    
    @Override
    public byte $set$orassign(byte value) {
        return this.val |= value;
    }
    
    

    @Override
    public byte $set$addassign(int index, byte value) {
        if (index != 0) {
            throw new IllegalArgumentException("Index must be zero to access to the single variable!");
        }
        return this.val += value;
    }

    @Override
    public byte $set$addassign(byte value) {
        return this.val += value;
    }

    @Override
    public byte $set$minusassign(int index, byte value) {
        if (index != 0) {
            throw new IllegalArgumentException("Index must be zero to access to the single variable!");
        }
        return this.val -= value;
    }

    @Override
    public byte $set$minusassign(byte value) {
        return this.val -= value;
    }

    @Override
    public byte $set$starassign(int index, byte value) {
        if (index != 0) {
            throw new IllegalArgumentException("Index must be zero to access to the single variable!");
        }
        return this.val *= value;
    }

    @Override
    public byte $set$starassign(byte value) {
        return this.val *= value;
    }

    @Override
    public byte $set$slashassign(int index, byte value) {
        if (index != 0) {
            throw new IllegalArgumentException("Index must be zero to access to the single variable!");
        }
        return this.val /= value;
    }

    @Override
    public byte $set$slashassign(byte value) {
        return this.val /= value;
    }

    @Override
    public byte $set$modassign(int index, byte value) {
        if (index != 0) {
            throw new IllegalArgumentException("Index must be zero to access to the single variable!");
        }
        return this.val %= value;
    }

    @Override
    public byte $set$modassign(byte value) {
        return this.val %= value;
    }

    @Override
    public byte $set$lshiftassign(int index, byte value) {
        if (index != 0) {
            throw new IllegalArgumentException("Index must be zero to access to the single variable!");
        }
        return this.val <<= value;
    }

    @Override
    public byte $set$rshiftassign(int index, byte value) {
        if (index != 0) {
            throw new IllegalArgumentException("Index must be zero to access to the single variable!");
        }
        return this.val >>= value;
    }

    @Override
    public byte $set$rshiftassign(byte value) {
        return this.val >>= value;
    }

    @Override
    public byte $set$postInc(int index) {
        return this.val++;
    }

    @Override
    public byte $set$postInc() {
        return this.val++;
    }

    @Override
    public byte $set$postDec(int index) {
        return this.val--;
    }

    @Override
    public byte $set$postDec() {
        return this.val--;
    }

    @Override
    public byte $set$preInc(int index) {
        return ++this.val;
    }

    @Override
    public byte $set$preInc() {
        return ++this.val;
    }

    @Override
    public byte $set$preDec(int index) {
        return --this.val;
    }

    @Override
    public byte $set$preDec() {
        return --this.val;
    }

    

    @Override
    public uchar$ptr $assign(uchar$ptr value) {
        throw new UnsupportedOperationException("Use $set(value.$star()) instead!");
    }

    @Override
    public uchar$ref star$ref() {
      return this;
    }

    @Override
    public uchar$ptr deref$ptr() {
      return this;
    }

    @Override
    public String toString() {
      return "uchar$ptr$single{" + val + "}";
    }    

    ////////////////////////////////////////////////////////////////////////////
    // statistics
    private static long instances = 0;
    
    public static void trackInstance() {        
        if (NativeTrace.STATISTICS) instances++;
    }

    public static void clearStatistics() {        
        instances = 0;
    }

    public static long printStatistics(java.io.PrintWriter out) {
        out.printf("%22s created:\t%s%n", uchar$ptr$single.class.getSimpleName(), NativeTrace.formatNumber(instances));
        return instances;
    }

    ///////////////////////////////////////////////////////////////////////////
    // performance access operations

    @Override
    public int $index() {
      throw new UnsupportedOperationException("Not supported; create array based instance instead");
    }

    @Override
    public byte[] $array() {
      throw new UnsupportedOperationException("Not supported; create array based instance instead");
    }

}