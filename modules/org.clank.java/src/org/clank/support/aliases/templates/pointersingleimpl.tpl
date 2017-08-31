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
 * Lightest implementation of pointer to ${TYPE}
 */
//<editor-fold defaultstate="collapsed" desc="template">
@Converted(kind = Converted.Kind.DUMMY, source = "${SPUTNIK}/modules/org.clank.java/src/org/clank/support/aliases/templates/pointersingleimpl.tpl")
//</editor-fold>
public final class ${FILE_NAME}${CLASS_SUFFIX} extends AbstractSinglePointerType<${POINTER_NAME}> implements ${POINTER_NAME}, ${REFERENCE_NAME} {
    
    private ${TYPE} val;

    public ${FILE_NAME}() {
        this((${TYPE})${DEFAULT_VALUE});
    }
    
    public ${FILE_NAME}(${TYPE} val) {
        this.val = val;
        trackInstance();
    }

    ////////////////////////////////////////////////////////////////////////////
    // common operations
    @Override
    public boolean $isNull() {
      return ${IS_NULL_CHECK};
    }
  
    @Override
    public ${TYPE} $deref() {
      return $star();
    }

    @Override
    public ${TYPE} $star() {
      return val;
    }

    @Override
    public ${TYPE} $set(${TYPE} value) {
        ${SET_IMPL}
        return val;
    }

    @Override
    public ${TYPE} $at(int index) {
        if (index != 0) {
            throw new IllegalArgumentException("Index must be zero to access to the single variable!");
        }
        return val;
    }

    @Override
    public ${TYPE} $set(int index, ${TYPE} value) {
        if (index != 0) {
            throw new IllegalArgumentException("Index must be zero to access to the single variable!");
        }
        return this.val = value;
    }       
    ${BUILTIN_TYPE_MODIFY_VALUE_SECTION_START}
    @Override
    public ${TYPE} $set$andassign(int index, ${TYPE} value) {
        if (index != 0) {
            throw new IllegalArgumentException("Index must be zero to access to the single variable!");
        }
        return this.val &= value;
    }

    @Override
    public ${TYPE} $set$andassign(${TYPE} value) {
        return this.val &= value;
    }

    @Override
    public ${TYPE} $set$xorassign(int index, ${TYPE} value) {
        if (index != 0) {
            throw new IllegalArgumentException("Index must be zero to access to the single variable!");
        }
        return this.val ^= value;
    }

    @Override
    public ${TYPE} $set$xorassign(${TYPE} value) {
        return this.val ^= value;
    }

    @Override
    public ${TYPE} $set$orassign(int index, ${TYPE} value) {
        if (index != 0) {
            throw new IllegalArgumentException("Index must be zero to access to the single variable!");
        }
        return this.val |= value;
    }
    
    @Override
    public ${TYPE} $set$orassign(${TYPE} value) {
        return this.val |= value;
    }
    
    ${BUILTIN_TYPE_MODIFY_VALUE_SECTION_END}${ADDITIONAL_MODIFY_VALUE_SECTION_START}

    @Override
    public ${TYPE} $set$addassign(int index, ${TYPE} value) {
        if (index != 0) {
            throw new IllegalArgumentException("Index must be zero to access to the single variable!");
        }
        return this.val += value;
    }

    @Override
    public ${TYPE} $set$addassign(${TYPE} value) {
        return this.val += value;
    }

    @Override
    public ${TYPE} $set$minusassign(int index, ${TYPE} value) {
        if (index != 0) {
            throw new IllegalArgumentException("Index must be zero to access to the single variable!");
        }
        return this.val -= value;
    }

    @Override
    public ${TYPE} $set$minusassign(${TYPE} value) {
        return this.val -= value;
    }

    @Override
    public ${TYPE} $set$starassign(int index, ${TYPE} value) {
        if (index != 0) {
            throw new IllegalArgumentException("Index must be zero to access to the single variable!");
        }
        return this.val *= value;
    }

    @Override
    public ${TYPE} $set$starassign(${TYPE} value) {
        return this.val *= value;
    }

    @Override
    public ${TYPE} $set$slashassign(int index, ${TYPE} value) {
        if (index != 0) {
            throw new IllegalArgumentException("Index must be zero to access to the single variable!");
        }
        return this.val /= value;
    }

    @Override
    public ${TYPE} $set$slashassign(${TYPE} value) {
        return this.val /= value;
    }

    @Override
    public ${TYPE} $set$modassign(int index, ${TYPE} value) {
        if (index != 0) {
            throw new IllegalArgumentException("Index must be zero to access to the single variable!");
        }
        return this.val %= value;
    }

    @Override
    public ${TYPE} $set$modassign(${TYPE} value) {
        return this.val %= value;
    }

    @Override
    public ${TYPE} $set$lshiftassign(int index, ${TYPE} value) {
        if (index != 0) {
            throw new IllegalArgumentException("Index must be zero to access to the single variable!");
        }
        return this.val <<= value;
    }

    @Override
    public ${TYPE} $set$rshiftassign(int index, ${TYPE} value) {
        if (index != 0) {
            throw new IllegalArgumentException("Index must be zero to access to the single variable!");
        }
        return this.val >>= value;
    }

    @Override
    public ${TYPE} $set$rshiftassign(${TYPE} value) {
        return this.val >>= value;
    }

    @Override
    public ${TYPE} $set$postInc(int index) {
        return this.val++;
    }

    @Override
    public ${TYPE} $set$postInc() {
        return this.val++;
    }

    @Override
    public ${TYPE} $set$postDec(int index) {
        return this.val--;
    }

    @Override
    public ${TYPE} $set$postDec() {
        return this.val--;
    }

    @Override
    public ${TYPE} $set$preInc(int index) {
        return ++this.val;
    }

    @Override
    public ${TYPE} $set$preInc() {
        return ++this.val;
    }

    @Override
    public ${TYPE} $set$preDec(int index) {
        return --this.val;
    }

    @Override
    public ${TYPE} $set$preDec() {
        return --this.val;
    }

    ${ADDITIONAL_MODIFY_VALUE_SECTION_END}

    @Override
    public ${POINTER_NAME} $assign(${POINTER_NAME} value) {
        throw new UnsupportedOperationException("Use $set(value.$star()) instead!");
    }

    @Override
    public ${REFERENCE_NAME} star$ref() {
      return this;
    }

    @Override
    public ${POINTER_NAME} deref$ptr() {
      return this;
    }

    @Override
    public String toString() {
      return "${FILE_NAME}{" + ${STRING_VAL} + "}";
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
        out.printf("%22s created:\t%s%n", ${FILE_NAME}.class.getSimpleName(), NativeTrace.formatNumber(instances));
        return instances;
    }

    ///////////////////////////////////////////////////////////////////////////
    // performance access operations

    @Override
    public int $index() {
      throw new UnsupportedOperationException("Not supported; create array based instance instead");
    }

    @Override
    public ${TYPE}[] $array() {
      throw new UnsupportedOperationException("Not supported; create array based instance instead");
    }

}