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

package org.clang.sema;

import org.clank.support.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;


/// \brief Retains information about a captured region.
//<editor-fold defaultstate="collapsed" desc="clang::sema::CapturedRegionScopeInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 624,
 FQN="clang::sema::CapturedRegionScopeInfo", NM="_ZN5clang4sema23CapturedRegionScopeInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema23CapturedRegionScopeInfoE")
//</editor-fold>
public final class CapturedRegionScopeInfo extends /*public*/ CapturingScopeInfo implements Destructors.ClassWithDestructor {
/*public:*/
  /// \brief The CapturedDecl for this statement.
  public CapturedDecl /*P*/ TheCapturedDecl;
  /// \brief The captured record type.
  public RecordDecl /*P*/ TheRecordDecl;
  /// \brief This is the enclosing scope of the captured region.
  public Scope /*P*/ TheScope;
  /// \brief The implicit parameter for the captured variables.
  public ImplicitParamDecl /*P*/ ContextParam;
  /// \brief The kind of captured region.
  public /*ushort*/char CapRegionKind;
  public /*ushort*/char OpenMPLevel;
  
  //<editor-fold defaultstate="collapsed" desc="clang::sema::CapturedRegionScopeInfo::CapturedRegionScopeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 638,
   FQN="clang::sema::CapturedRegionScopeInfo::CapturedRegionScopeInfo", NM="_ZN5clang4sema23CapturedRegionScopeInfoC1ERNS_17DiagnosticsEngineEPNS_5ScopeEPNS_12CapturedDeclEPNS_10RecordDeclEPNS_17ImplicitParamDeclENS_18CapturedRegionKindEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema23CapturedRegionScopeInfoC1ERNS_17DiagnosticsEngineEPNS_5ScopeEPNS_12CapturedDeclEPNS_10RecordDeclEPNS_17ImplicitParamDeclENS_18CapturedRegionKindEj")
  //</editor-fold>
  public CapturedRegionScopeInfo(final DiagnosticsEngine /*&*/ Diag, Scope /*P*/ S, CapturedDecl /*P*/ CD, 
      RecordDecl /*P*/ RD, ImplicitParamDecl /*P*/ Context, 
      CapturedRegionKind K, /*uint*/int OpenMPLevel) {
    // : CapturingScopeInfo(Diag, ImpCap_CapturedRegion), TheCapturedDecl(CD), TheRecordDecl(RD), TheScope(S), ContextParam(Context), CapRegionKind(K), OpenMPLevel(OpenMPLevel) 
    //START JInit
    super(Diag, ImplicitCaptureStyle.ImpCap_CapturedRegion);
    this.TheCapturedDecl = CD;
    this.TheRecordDecl = RD;
    this.TheScope = S;
    this.ContextParam = Context;
    this.CapRegionKind = (char) K.getValue();
    this.OpenMPLevel = $uint2ushort(OpenMPLevel);
    //END JInit
    Kind = ScopeKind.SK_CapturedRegion;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::sema::CapturedRegionScopeInfo::~CapturedRegionScopeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp", line = 243,
   FQN="clang::sema::CapturedRegionScopeInfo::~CapturedRegionScopeInfo", NM="_ZN5clang4sema23CapturedRegionScopeInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema23CapturedRegionScopeInfoD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    super.$destroy();
  }

  
  /// \brief A descriptive name for the kind of captured region this is.
  //<editor-fold defaultstate="collapsed" desc="clang::sema::CapturedRegionScopeInfo::getRegionName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 651,
   FQN="clang::sema::CapturedRegionScopeInfo::getRegionName", NM="_ZNK5clang4sema23CapturedRegionScopeInfo13getRegionNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZNK5clang4sema23CapturedRegionScopeInfo13getRegionNameEv")
  //</editor-fold>
  public StringRef getRegionName() /*const*/ {
    switch (CapturedRegionKind.valueOf($ushort2int(CapRegionKind))) {
     case CR_Default:
      return new StringRef(/*KEEP_STR*/"default captured statement");
     case CR_OpenMP:
      return new StringRef(/*KEEP_STR*/"OpenMP region");
    }
    throw new llvm_unreachable("Invalid captured region kind!");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::sema::CapturedRegionScopeInfo::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 661,
   FQN="clang::sema::CapturedRegionScopeInfo::classof", NM="_ZN5clang4sema23CapturedRegionScopeInfo7classofEPKNS0_17FunctionScopeInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema23CapturedRegionScopeInfo7classofEPKNS0_17FunctionScopeInfoE")
  //</editor-fold>
  public static boolean classof(/*const*/ FunctionScopeInfo /*P*/ FSI) {
    return FSI.Kind == ScopeKind.SK_CapturedRegion;
  }

  
  @Override public String toString() {
    return "" + "TheCapturedDecl=" + TheCapturedDecl // NOI18N
              + ", TheRecordDecl=" + TheRecordDecl // NOI18N
              + ", TheScope=" + TheScope // NOI18N
              + ", ContextParam=" + ContextParam // NOI18N
              + ", CapRegionKind=" + $ushort2uint(CapRegionKind) // NOI18N
              + ", OpenMPLevel=" + $ushort2uint(OpenMPLevel) // NOI18N
              + super.toString(); // NOI18N
  }
}
