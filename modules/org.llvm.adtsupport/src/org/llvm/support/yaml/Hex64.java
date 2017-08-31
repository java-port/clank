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

//<editor-fold defaultstate="collapsed" desc="llvm::yaml::Hex64">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1208,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1178,
 FQN="llvm::yaml::Hex64", NM="_ZN4llvm4yaml5Hex64E",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Hex64E")
//</editor-fold>
public class/*struct*/ Hex64 implements Native.NativeComparable<Hex64> {
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Hex64::Hex64">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1208,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1178,
   FQN="llvm::yaml::Hex64::Hex64", NM="_ZN4llvm4yaml5Hex64C1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Hex64C1Ev")
  //</editor-fold>
  public Hex64() {
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Hex64::Hex64">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1208,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1178,
   FQN="llvm::yaml::Hex64::Hex64", NM="_ZN4llvm4yaml5Hex64C1Ey",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Hex64C1Ey")
  //</editor-fold>
  public Hex64(/*const*/long/*uint64_t*/ v) {
    // : value(v) 
    //START JInit
    this.value = v;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Hex64::Hex64">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1208,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1178,
   FQN="llvm::yaml::Hex64::Hex64", NM="_ZN4llvm4yaml5Hex64C1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Hex64C1ERKS1_")
  //</editor-fold>
  public Hex64(final /*const*/ Hex64 /*&*/ v) {
    // : value(v.value) 
    //START JInit
    this.value = v.value;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Hex64::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1208,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1178,
   FQN="llvm::yaml::Hex64::operator=", NM="_ZN4llvm4yaml5Hex64aSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Hex64aSERKS1_")
  //</editor-fold>
  public Hex64 /*&*/ $assign(final /*const*/ Hex64 /*&*/ rhs) {
    value = rhs.value;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Hex64::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1208,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1178,
   FQN="llvm::yaml::Hex64::operator=", NM="_ZN4llvm4yaml5Hex64aSERKy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Hex64aSERKy")
  //</editor-fold>
  public Hex64 /*&*/ $assign(final /*const*/ulong$ref/*uint64_t &*/ rhs) {
    value = rhs.$deref();
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Hex64::operator const unsigned long long & ">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1208,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1178,
   FQN="llvm::yaml::Hex64::operator const unsigned long long & ", NM="_ZNK4llvm4yaml5Hex64cvRKyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZNK4llvm4yaml5Hex64cvRKyEv")
  //</editor-fold>
  public /*const*/ulong$ref/*uint64_t &*/ $ulong$ref$C() /*const*/ {
    return value_ref;//value;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Hex64::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1208,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1178,
   FQN="llvm::yaml::Hex64::operator==", NM="_ZNK4llvm4yaml5Hex64eqERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZNK4llvm4yaml5Hex64eqERKS1_")
  //</editor-fold>
  public boolean $eq(final /*const*/ Hex64 /*&*/ rhs) /*const*/ {
    return value == rhs.value;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Hex64::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1208,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1178,
   FQN="llvm::yaml::Hex64::operator==", NM="_ZNK4llvm4yaml5Hex64eqERKy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZNK4llvm4yaml5Hex64eqERKy")
  //</editor-fold>
  public boolean $eq(final /*const*/ulong$ref/*uint64_t &*/ rhs) /*const*/ {
    return value == rhs.$deref();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Hex64::operator<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1208,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1178,
   FQN="llvm::yaml::Hex64::operator<", NM="_ZNK4llvm4yaml5Hex64ltERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZNK4llvm4yaml5Hex64ltERKS1_")
  //</editor-fold>
  public boolean $less(final /*const*/ Hex64 /*&*/ rhs) /*const*/ {
    return $less_ulong(value, rhs.value);
  }

  public long/*uint64_t*/ value;
  // JAVA: typedef uint64_t BaseType;

  public ulong$ref value_ref = new ulong$ref(){
    @Override
    public long $deref() {
      return value;
    }

    @Override
    public long $set(long v) {
      value = v;
      return value;
    }
  };
  
  @Override public String toString() {
    return "" + "value=" + value; // NOI18N
  }
}
