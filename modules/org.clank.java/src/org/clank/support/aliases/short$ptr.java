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
import org.clank.support.abstract_pointer;

/**
 * Pointer to short
 */
//<editor-fold defaultstate="collapsed" desc="template">
@Converted(kind = Converted.Kind.DUMMY, source = "${SPUTNIK}/modules/org.clank.java/src/org/clank/support/aliases/templates/pointer.tpl")
//</editor-fold>
public interface short$ptr extends abstract_pointer<short$ptr>, short$iterator<short$ptr> {
    /**
      * Accessors for performance critical paths
      */
    default int $index() { throw new UnsupportedOperationException("Why not implemented in " + this.getClass());}
    default short[] $array() { throw new UnsupportedOperationException("Why not implemented in " + this.getClass());}

    /**
     * Gets value from pointer ('*x' in C++)
     * 
     * @return value
     */
    short $star();

    /**
     * Gets reference from pointer ('*x' passed to '&T')
     * 
     * @return reference to memory
     */
    default short$ref star$ref() { throw new UnsupportedOperationException("Why not implemented in " + this.getClass());}
    
    /**
     * Replaces value in pointer ('*x = value' in C++)
     * 
     * @param value - new value
     * @return value
     */
    default short $set(short value) { throw new UnsupportedOperationException("Why not implemented in " + this.getClass());}

    @Override public default void swap(org.clank.support.NativeSwappable other) {    
      short val = $star();
      short$ptr RHS = (short$ptr)other;
      this.$set(RHS.$star());
      RHS.$set(val);
    }
    
    /**
     * Gets value from pointer at the given index ('x[10]' in C++)
     * 
     * @return value
     */        
    default short $at(int index) { throw new UnsupportedOperationException("Why not implemented in " + this.getClass());}
    default short $at(uint$ref index) { return $at(index.$deref()); }
    default short $at(int$ref index) { return $at(index.$deref()); }
    
    /**
     * Replaces value in pointer at the given index ('x[10] = value' in C++)
     * 
     * @param value - new value
     * @return value
     */
    default short $set(int index, short value) { throw new UnsupportedOperationException("Why not implemented in " + this.getClass());}
    default short $set(uint$ref index, short value) { return $set(index.$deref(), value); }
    default short $set(int$ref index, short value) { return $set(index.$deref(), value); }

    /**
     * modify value at the given index (i.e. 'x[10] += value' in C++)
     * 
     * @param value - value
     * @return value
     */
    default short $set$andassign(int index, short value) {// "&=" 
     // return $set(index, $at(index) & value);
     throw new UnsupportedOperationException("Why not implemented in " + this.getClass());
    }
    
    default short $set$xorassign(int index, short value) {// "^="
      //return $set(index, $at(index) ^ value); 
      throw new UnsupportedOperationException("Why not implemented in " + this.getClass());
    }
    
    default short $set$orassign(int index, short value) {// "|=" 
      //return $set(index, $at(index) | value); 
      throw new UnsupportedOperationException("Why not implemented in " + this.getClass());
    }
    
    
    default short $set$addassign(int index, short value) {// "+=" 
      //return $set(index, $at(index) + value); 
      throw new UnsupportedOperationException("Why not implemented in " + this.getClass());
    }
    
    default short $set$minusassign(int index, short value) {// "-="
      //return $set(index, $at(index) - value); 
      throw new UnsupportedOperationException("Why not implemented in " + this.getClass());
    }
    
    default short $set$starassign(int index, short value) {// "*="    
      //return $set(index, $at(index) * value); 
      throw new UnsupportedOperationException("Why not implemented in " + this.getClass());
    }
    
    default short $set$slashassign(int index, short value) {// "/="
      throw new UnsupportedOperationException("Why not correctly implemented signed/unsigned divide in " + this.getClass());
    }
    
    default short $set$modassign(int index, short value) {// "%=" 
      throw new UnsupportedOperationException("Why not correctly implemented signed/unsigned reminder in " + this.getClass());
    }
    
    default short $set$lshiftassign(int index, short value) {// "<<="
      // return $set(index, $at(index) << value); 
      throw new UnsupportedOperationException("Why not implemented in " + this.getClass());
    }
    
    default short $set$rshiftassign(int index, short value) {// ">>="
      throw new UnsupportedOperationException("Why not correctly implemented signed/unsigned right-shift in " + this.getClass());
    }
    
    default short $set$postInc(int index) { // "x++"    
      //short out = $at(index);
      //$set(index,  out+1); 
      //return out;
      throw new UnsupportedOperationException("Why not implemented in " + this.getClass());
    }
    
    default short $set$postDec(int index) { // "x--"   
      //short out = $at(index);
      //$set(index,  out-1); 
      //return out;
      throw new UnsupportedOperationException("Why not implemented in " + this.getClass());
    }
    
    default short $set$preInc(int index) {// "++x"    
      //return $set(index, $at(index)-1); 
      throw new UnsupportedOperationException("Why not implemented in " + this.getClass());
    }
    
    default short $set$preDec(int index) {// "--x"  
      //return $set(index, $at(index)-1); 
      throw new UnsupportedOperationException("Why not implemented in " + this.getClass());
    }
    
}        