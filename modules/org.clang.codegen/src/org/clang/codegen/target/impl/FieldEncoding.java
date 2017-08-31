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

package org.clang.codegen.target.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.codegen.target.impl.*;


/// TypeString encodings for enum & union fields must be order.
/// FieldEncoding is a helper for this ordering process.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FieldEncoding">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 7301,
 FQN="(anonymous namespace)::FieldEncoding", NM="_ZN12_GLOBAL__N_113FieldEncodingE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_113FieldEncodingE")
//</editor-fold>
public class FieldEncoding implements ComparableLower, Destructors.ClassWithDestructor {
  private boolean HasName;
  private std.string Enc;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FieldEncoding::FieldEncoding">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 7305,
   FQN="(anonymous namespace)::FieldEncoding::FieldEncoding", NM="_ZN12_GLOBAL__N_113FieldEncodingC1EbRN4llvm11SmallStringILj128EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_113FieldEncodingC1EbRN4llvm11SmallStringILj128EEE")
  //</editor-fold>
  public FieldEncoding(boolean b, final SmallString/*128*/ /*&*/ e) {
    // : HasName(b), Enc(e.c_str()) 
    //START JInit
    this.HasName = b;
    this.Enc = new std.string(JD$T$C$P_T2$C$R.INSTANCE, e.c_str());
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FieldEncoding::str">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 7306,
   FQN="(anonymous namespace)::FieldEncoding::str", NM="_ZN12_GLOBAL__N_113FieldEncoding3strEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_113FieldEncoding3strEv")
  //</editor-fold>
  public StringRef str() {
    return new StringRef(Enc.c_str());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FieldEncoding::operator<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 7307,
   FQN="(anonymous namespace)::FieldEncoding::operator<", NM="_ZNK12_GLOBAL__N_113FieldEncodingltERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_113FieldEncodingltERKS0_")
  //</editor-fold>
  public boolean $less(final /*const*/ FieldEncoding /*&*/ rhs) /*const*/ {
    if (HasName != rhs.HasName) {
      return HasName;
    }
    return $less_string$C(Enc, rhs.Enc);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FieldEncoding::FieldEncoding">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 7301,
   FQN="(anonymous namespace)::FieldEncoding::FieldEncoding", NM="_ZN12_GLOBAL__N_113FieldEncodingC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_113FieldEncodingC1EOS0_")
  //</editor-fold>
  public /*inline*/ FieldEncoding(JD$Move _dparam, final FieldEncoding /*&&*/$Prm0) {
    // : HasName(static_cast<FieldEncoding &&>().HasName), Enc(static_cast<FieldEncoding &&>().Enc) 
    //START JInit
    this.HasName = $Prm0.HasName;
    this.Enc = new std.string(JD$Move.INSTANCE, $Prm0.Enc);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FieldEncoding::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 7301,
   FQN="(anonymous namespace)::FieldEncoding::operator=", NM="_ZN12_GLOBAL__N_113FieldEncodingaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_113FieldEncodingaSEOS0_")
  //</editor-fold>
  public /*inline*/ FieldEncoding /*&*/ $assignMove(final FieldEncoding /*&&*/$Prm0) {
    this.HasName = $Prm0.HasName;
    this.Enc.$assignMove($Prm0.Enc);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FieldEncoding::~FieldEncoding">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 7301,
   FQN="(anonymous namespace)::FieldEncoding::~FieldEncoding", NM="_ZN12_GLOBAL__N_113FieldEncodingD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_113FieldEncodingD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Enc.$destroy();
    //END JDestroy
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public FieldEncoding() {
    this.HasName = false;
    this.Enc = std.string.EMPTY;
  }
  @Override
  public boolean $less(Object obj) {
    return $less((FieldEncoding) obj);
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "HasName=" + HasName // NOI18N
              + ", Enc=" + Enc; // NOI18N
  }
}
