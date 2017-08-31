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
import org.clank.support.AbstractHeavyPointerType;

/**
 * Heavy implementation of pointer to short
 */
//<editor-fold defaultstate="collapsed" desc="template">
@Converted(kind = Converted.Kind.DUMMY, source = "${SPUTNIK}/modules/org.clank.java/src/org/clank/support/aliases/templates/pointerheavyimpl.tpl")
//</editor-fold>
public class short$ptr$heavy extends AbstractHeavyPointerType<short$ptr, short$memory> implements short$ptr {

    public short$ptr$heavy(short value) {
        this(new short$mem(value), 0, null, 0);
    }

    public short$ptr$heavy(short[] values) {
        this(new short$mem(values), 0, null, 0);
    }

    public short$ptr$heavy(short[] values, int index) {
        this(new short$mem(values), index, null, 0);
    }
    
    public short$ptr$heavy(short$memory values) {
        this(values, 0, null, 0);
    }
      
    public short$ptr$heavy(short$memory values, int index) {
        this(values, index, null, 0);
    }        
    
    public short$ptr$heavy(short$memory values, int index, type$memory<short$ptr> selfMemory, int selfIndex) {
        super(values, index, selfMemory, selfIndex);
    }

    @Override
    public short $star() {
        return $at(0);
    }

    @Override
    public short $set(short value) {
        return $set(0, value);
    }

    @Override
    public short $at(int index) {
        return memory.$at(this.index + index);
    }

    @Override
    public short $set(int index, short value) {
        return memory.$set(this.index + index, value);
    }
    
    @Override
    public short $set$andassign(int index, short value) {
        return memory.$set$andassign(this.index + index, value);
    }

    @Override
    public short $set$xorassign(int index, short value) {
        return memory.$set$xorassign(this.index + index, value);
    }

    @Override
    public short $set$orassign(int index, short value) {
        return memory.$set$orassign(this.index + index, value);
    }

    

    @Override
    public short $set$addassign(int index, short value) {
        return memory.$set$addassign(this.index + index, value);
    }

    @Override
    public short $set$minusassign(int index, short value) {
        return memory.$set$minusassign(this.index + index, value);
    }

    @Override
    public short $set$starassign(int index, short value) {
        return memory.$set$starassign(this.index + index, value);
    }

    @Override
    public short $set$slashassign(int index, short value) {
        return memory.$set$slashassign(this.index + index, value);
    }

    @Override
    public short $set$modassign(int index, short value) {
        return memory.$set$modassign(this.index + index, value);
    }

    @Override
    public short $set$lshiftassign(int index, short value) {
        return memory.$set$lshiftassign(this.index + index, value);
    }

    @Override
    public short $set$rshiftassign(int index, short value) {
        return memory.$set$rshiftassign(this.index + index, value);
    }

    @Override
    public short $set$postInc(int index) {
        return memory.$set$postInc(index);
    }

    @Override
    public short $set$postDec(int index) {
        return memory.$set$postDec(index);
    }

    @Override
    public short $set$preInc(int index) {
        return memory.$set$preInc(index);
    }

    @Override
    public short $set$preDec(int index) {
        return memory.$set$preDec(index);
    }

    

    @Override
    public short$ref star$ref() {
      throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override 
    public short$ptr$heavy clone() {
      return (short$ptr$heavy)new short$ptr$heavy(memory, index);
    }

    @Override
    public short[] $array() {
      throw new UnsupportedOperationException("Not supported; create array based instance instead");
    }
}