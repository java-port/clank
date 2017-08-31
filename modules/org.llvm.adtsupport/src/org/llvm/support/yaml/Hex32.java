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

package org.llvm.support.yaml;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Unsigned.*;

//<editor-fold defaultstate="collapsed" desc="llvm::yaml::Hex32">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1207,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1177,
 FQN="llvm::yaml::Hex32", NM="_ZN4llvm4yaml5Hex32E",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Hex32E")
//</editor-fold>
public class/*struct*/ Hex32 implements Native.NativeComparable<Hex32> {
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Hex32::Hex32">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1207,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1177,
   FQN="llvm::yaml::Hex32::Hex32", NM="_ZN4llvm4yaml5Hex32C1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Hex32C1Ev")
  //</editor-fold>
  public Hex32() {
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Hex32::Hex32">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1207,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1177,
   FQN="llvm::yaml::Hex32::Hex32", NM="_ZN4llvm4yaml5Hex32C1Ej",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Hex32C1Ej")
  //</editor-fold>
  public Hex32(/*const*//*uint32_t*/int v) {
    // : value(v) 
    //START JInit
    this.value = v;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Hex32::Hex32">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1207,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1177,
   FQN="llvm::yaml::Hex32::Hex32", NM="_ZN4llvm4yaml5Hex32C1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Hex32C1ERKS1_")
  //</editor-fold>
  public Hex32(final /*const*/ Hex32 /*&*/ v) {
    // : value(v.value) 
    //START JInit
    this.value = v.value;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Hex32::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1207,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1177,
   FQN="llvm::yaml::Hex32::operator=", NM="_ZN4llvm4yaml5Hex32aSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Hex32aSERKS1_")
  //</editor-fold>
  public Hex32 /*&*/ $assign(final /*const*/ Hex32 /*&*/ rhs) {
    value = rhs.value;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Hex32::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1207,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1177,
   FQN="llvm::yaml::Hex32::operator=", NM="_ZN4llvm4yaml5Hex32aSERKj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Hex32aSERKj")
  //</editor-fold>
  public Hex32 /*&*/ $assign(final /*const*//*uint32_t &*/uint$ref rhs) {
    value = rhs.$deref();
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Hex32::operator const unsigned int & ">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1207,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1177,
   FQN="llvm::yaml::Hex32::operator const unsigned int & ", NM="_ZNK4llvm4yaml5Hex32cvRKjEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZNK4llvm4yaml5Hex32cvRKjEv")
  //</editor-fold>
  public /*const*//*uint32_t &*/uint$ref $uint$ref$C() /*const*/ {
    return value_ref;//value;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Hex32::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1207,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1177,
   FQN="llvm::yaml::Hex32::operator==", NM="_ZNK4llvm4yaml5Hex32eqERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZNK4llvm4yaml5Hex32eqERKS1_")
  //</editor-fold>
  public boolean $eq(final /*const*/ Hex32 /*&*/ rhs) /*const*/ {
    return value == rhs.value;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Hex32::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1207,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1177,
   FQN="llvm::yaml::Hex32::operator==", NM="_ZNK4llvm4yaml5Hex32eqERKj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZNK4llvm4yaml5Hex32eqERKj")
  //</editor-fold>
  public boolean $eq(final /*const*//*uint32_t &*/uint$ref rhs) /*const*/ {
    return value == rhs.$deref();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Hex32::operator<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1207,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1177,
   FQN="llvm::yaml::Hex32::operator<", NM="_ZNK4llvm4yaml5Hex32ltERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZNK4llvm4yaml5Hex32ltERKS1_")
  //</editor-fold>
  public boolean $less(final /*const*/ Hex32 /*&*/ rhs) /*const*/ {
    return $less_uint(value, rhs.value);
  }

  public /*uint32_t*/int value;
  // JAVA: typedef uint32_t BaseType;
  
  public uint$ref value_ref = new uint$ref(){
    @Override
    public int $deref() {
      return value;
    }

    @Override
    public int $set(int v) {
      value = v;
      return value;
    }
  };
  
  @Override public String toString() {
    return "" + "value=" + value; // NOI18N
  }
}
