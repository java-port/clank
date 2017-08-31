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

package org.clang.ast.impl;

import static org.clank.support.Native.$Deref;
import org.clank.support.*;
import org.clank.support.aliases.char$ptr;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.ast.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.basic.PartialDiagnostic.*;
import static org.clank.support.NativePointer.$;


/// A partial diagnostic which we might know in advance that we are not going
/// to emit.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OptionalDiagnostic">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*extra $out*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 366,
 FQN="(anonymous namespace)::OptionalDiagnostic", NM="_ZN12_GLOBAL__N_118OptionalDiagnosticE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_118OptionalDiagnosticE")
//</editor-fold>
public class OptionalDiagnostic {
  private PartialDiagnostic /*P*/ Diag;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OptionalDiagnostic::OptionalDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 370,
   FQN="(anonymous namespace)::OptionalDiagnostic::OptionalDiagnostic", NM="_ZN12_GLOBAL__N_118OptionalDiagnosticC1EPN5clang17PartialDiagnosticE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_118OptionalDiagnosticC1EPN5clang17PartialDiagnosticE")
  //</editor-fold>
  public /*explicit*/ OptionalDiagnostic() {
    this((PartialDiagnostic /*P*/ )null);
  }
  public /*explicit*/ OptionalDiagnostic(PartialDiagnostic /*P*/ Diag/*= null*/) {
    // : Diag(Diag) 
    //START JInit
    this.Diag = Diag;
    //END JInit
  }

  
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OptionalDiagnostic::operator<<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 374,
   FQN="(anonymous namespace)::OptionalDiagnostic::operator<<", NM="Tpl__ZN12_GLOBAL__N_118OptionalDiagnosticlsERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=Tpl__ZN12_GLOBAL__N_118OptionalDiagnosticlsERKT_")
  //</editor-fold>
  public </*typename*/ T> OptionalDiagnostic /*&*/ $out$T(final /*const*/ T /*&*/ v) {
    if ((Diag != null)) {
      // Native.$out(/*Deref*/Diag, v);
      throw new UnsupportedOperationException("Need a specialization for " + v.getClass());
    }
    return /*Deref*/this;
  }

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public OptionalDiagnostic /*&*/ $out$T(final /*const*/ NamedDecl /*&*/ ND) {
    if ((Diag != null)) {
      // Native.$out(/*Deref*/Diag, v);
      $out_PartialDiagnostic$C_NamedDecl$C$P(Diag, ND);
    }
    return /*Deref*/this;
  }
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OptionalDiagnostic::operator<<">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 374,
   FQN="(anonymous namespace)::OptionalDiagnostic::operator<<", NM="_ZN12_GLOBAL__N_118OptionalDiagnosticlsIiEERS0_RKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_118OptionalDiagnosticlsIiEERS0_RKT_")
  //</editor-fold>
  public OptionalDiagnostic /*&*/ $out_int(final /*const*/ int /*&*/ v) {
    if ((Diag != null)) {
      $Deref($out_PartialDiagnostic$C_int(Diag, v));
    }
    return /*Deref*/this;
  }
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OptionalDiagnostic::operator<<">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 374,
   FQN="(anonymous namespace)::OptionalDiagnostic::operator<<", NM="_ZN12_GLOBAL__N_118OptionalDiagnosticlsIjEERS0_RKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_118OptionalDiagnosticlsIjEERS0_RKT_")
  //</editor-fold>
  public OptionalDiagnostic /*&*/ $out_uint(final /*const*/ /*uint*/int /*&*/ v) {
    if ((Diag != null)) {
      $Deref($out_PartialDiagnostic$C_uint(Diag, v));
    }
    return /*Deref*/this;
  }
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OptionalDiagnostic::operator<<">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 374,
   FQN="(anonymous namespace)::OptionalDiagnostic::operator<<", NM="_ZN12_GLOBAL__N_118OptionalDiagnosticlsIbEERS0_RKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_118OptionalDiagnosticlsIbEERS0_RKT_")
  //</editor-fold>
  public OptionalDiagnostic /*&*/ $out_bool(final /*const*/ boolean /*&*/ v) {
    if ((Diag != null)) {
      $Deref($out_PartialDiagnostic$C_int(Diag, v ? 1 : 0));
    }
    return /*Deref*/this;
  }
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OptionalDiagnostic::operator<<">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 374,
   FQN="(anonymous namespace)::OptionalDiagnostic::operator<<", NM="_ZN12_GLOBAL__N_118OptionalDiagnosticlsIiEERS0_RKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_118OptionalDiagnosticlsIiEERS0_RKT_")
  //</editor-fold>
  public OptionalDiagnostic /*&*/ $out$T(final /*const*/int/*&*/ v) {
    // FIXME: no way to distinguish int and unsigned, use int version
    return $out_int(v);
  }
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OptionalDiagnostic::operator<<">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 374,
   FQN="(anonymous namespace)::OptionalDiagnostic::operator<<", NM="_ZN12_GLOBAL__N_118OptionalDiagnosticlsI11AccessKindsEERS0_RKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_118OptionalDiagnosticlsI11AccessKindsEERS0_RKT_")
  //</editor-fold>
  public OptionalDiagnostic /*&*/ $out$T(final /*const*/ Native.NativeUIntEnum /*&*/ v) {
    return $out_uint(v.getValue());
  }
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OptionalDiagnostic::operator<<">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 374,
   FQN="(anonymous namespace)::OptionalDiagnostic::operator<<", NM="_ZN12_GLOBAL__N_118OptionalDiagnosticlsI11AccessKindsEERS0_RKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_118OptionalDiagnosticlsI11AccessKindsEERS0_RKT_")
  //</editor-fold>
  public OptionalDiagnostic /*&*/ $out$T(final /*const*/ Native.NativeIntEnum /*&*/ v) {
    return $out_int(v.getValue());
  }
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OptionalDiagnostic::operator<<">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 374,
   FQN="(anonymous namespace)::OptionalDiagnostic::operator<<", NM="_ZN12_GLOBAL__N_118OptionalDiagnosticlsIbEERS0_RKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_118OptionalDiagnosticlsIbEERS0_RKT_")
  //</editor-fold>
  public OptionalDiagnostic /*&*/ $out$T(final /*const*/ boolean /*&*/ v) {
    return $out_bool(v);
  }
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OptionalDiagnostic::operator<<">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 374,
   FQN="(anonymous namespace)::OptionalDiagnostic::operator<<", NM="_ZN12_GLOBAL__N_118OptionalDiagnosticlsIN5clang8QualTypeEEERS0_RKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_118OptionalDiagnosticlsIN5clang8QualTypeEEERS0_RKT_")
  //</editor-fold>
  public OptionalDiagnostic /*&*/ $out$T(final /*const*/ QualType /*&*/ v) {
    if ((Diag != null)) {
      $out_PartialDiagnostic$C_QualType($Deref(Diag), /*NO_COPY*/v);
    }
    return /*Deref*/this;
  }
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OptionalDiagnostic::operator<<">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 374,
   FQN="(anonymous namespace)::OptionalDiagnostic::operator<<", NM="_ZN12_GLOBAL__N_118OptionalDiagnosticlsIA9_cEERS0_RKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_118OptionalDiagnosticlsIA9_cEERS0_RKT_")
  //</editor-fold>
  public OptionalDiagnostic /*&*/ $out$T(final String /*const*/ /*&*/ v) {
    return $Deref($out$T($(v)));
  }
  public OptionalDiagnostic /*&*/ $out$T(final char$ptr /*const*/ /*&*/ v) {
    if ((Diag != null)) {
      PartialDiagnostic.$out_PartialDiagnostic$C_char$ptr$C($Deref(Diag), v);
    }
    return /*Deref*/this;
  }
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OptionalDiagnostic::operator<<">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 374,
   FQN="(anonymous namespace)::OptionalDiagnostic::operator<<", NM="_ZN12_GLOBAL__N_118OptionalDiagnosticlsIN5clang11SourceRangeEEERS0_RKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_118OptionalDiagnosticlsIN5clang11SourceRangeEEERS0_RKT_")
  //</editor-fold>
  public OptionalDiagnostic /*&*/ $out$T(final /*const*/ SourceRange /*&*/ v) {
    if ((Diag != null)) {
      PartialDiagnostic.$out_PartialDiagnostic$C_SourceRange($Deref(Diag), /*NO_COPY*/v);
    }
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OptionalDiagnostic::operator<<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 380,
   FQN="(anonymous namespace)::OptionalDiagnostic::operator<<", NM="_ZN12_GLOBAL__N_118OptionalDiagnosticlsERKN4llvm6APSIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_118OptionalDiagnosticlsERKN4llvm6APSIntE")
  //</editor-fold>
  public OptionalDiagnostic /*&*/ $out(final /*const*/ APSInt /*&*/ I) {
    if ((Diag != null)) {
      SmallString Buffer/*J*/= new SmallString(32);
      I.__toString(Buffer);
      $out_PartialDiagnostic$C_StringRef($Deref(Diag), new StringRef(Buffer.data(), Buffer.size()));
    }
    return /*Deref*/this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OptionalDiagnostic::operator<<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 389,
   FQN="(anonymous namespace)::OptionalDiagnostic::operator<<", NM="_ZN12_GLOBAL__N_118OptionalDiagnosticlsERKN4llvm7APFloatE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_118OptionalDiagnosticlsERKN4llvm7APFloatE")
  //</editor-fold>
  public OptionalDiagnostic /*&*/ $out(final /*const*/ APFloat /*&*/ F) {
    if ((Diag != null)) {
      // FIXME: Force the precision of the source value down so we don't
      // print digits which are usually useless (we don't really care here if
      // we truncate a digit by accident in edge cases).  Ideally,
      // APFloat::toString would automatically print the shortest 
      // representation which rounds to the correct value, but it's a bit
      // tricky to implement.
      /*uint*/int precision = APFloat.semanticsPrecision(F.getSemantics());
      precision = $div_uint((precision * 59 + 195), 196);
      SmallString Buffer/*J*/= new SmallString(32);
      F.__toString(Buffer, precision);
      $out_PartialDiagnostic$C_StringRef($Deref(Diag), new StringRef(Buffer.data(), Buffer.size()));
    }
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OptionalDiagnostic::OptionalDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 366,
   FQN="(anonymous namespace)::OptionalDiagnostic::OptionalDiagnostic", NM="_ZN12_GLOBAL__N_118OptionalDiagnosticC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_118OptionalDiagnosticC1EOS0_")
  //</editor-fold>
  public /*inline*/ OptionalDiagnostic(JD$Move _dparam, final OptionalDiagnostic /*&&*/$Prm0) {
    // : Diag(static_cast<OptionalDiagnostic &&>().Diag) 
    //START JInit
    this.Diag = $Prm0.Diag;
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "Diag=" + "[PartialDiagnostic]"; // NOI18N
  }
}
