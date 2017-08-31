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

package org.clang.sema.impl;

import org.clank.support.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstFunctionPointers.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CatchTypePublicBases">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 3604,
 FQN="(anonymous namespace)::CatchTypePublicBases", NM="_ZN12_GLOBAL__N_120CatchTypePublicBasesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN12_GLOBAL__N_120CatchTypePublicBasesE")
//</editor-fold>
public class CatchTypePublicBases implements BaseMatchesCallback {
  private final ASTContext /*&*/ Ctx;
  private final /*const*/DenseMap<CatchHandlerType, CXXCatchStmt /*P*/ > /*&*/ TypesToCheck;
  private /*const*/boolean CheckAgainstPointer;
  
  private CXXCatchStmt /*P*/ FoundHandler;
  private CanQual<Type> FoundHandlerType;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CatchTypePublicBases::CatchTypePublicBases">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 3613,
   FQN="(anonymous namespace)::CatchTypePublicBases::CatchTypePublicBases", NM="_ZN12_GLOBAL__N_120CatchTypePublicBasesC1ERN5clang10ASTContextERKN4llvm8DenseMapINS_16CatchHandlerTypeEPNS1_12CXXCatchStmtENS4_12DenseMapInfoIS6_EENS4_6detail12DenseMapPairIS6_S8_EEEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN12_GLOBAL__N_120CatchTypePublicBasesC1ERN5clang10ASTContextERKN4llvm8DenseMapINS_16CatchHandlerTypeEPNS1_12CXXCatchStmtENS4_12DenseMapInfoIS6_EENS4_6detail12DenseMapPairIS6_S8_EEEEb")
  //</editor-fold>
  public CatchTypePublicBases(final ASTContext /*&*/ Ctx, 
      final /*const*/DenseMap<CatchHandlerType, CXXCatchStmt /*P*/ > /*&*/ T, boolean C) {
    // : Ctx(Ctx), TypesToCheck(T), CheckAgainstPointer(C), FoundHandler(null), FoundHandlerType() 
    //START JInit
    this./*&*/Ctx=/*&*/Ctx;
    this./*&*/TypesToCheck=/*&*/T;
    this.CheckAgainstPointer = C;
    this.FoundHandler = null;
    this.FoundHandlerType = new CanQual<Type>();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CatchTypePublicBases::getFoundHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 3619,
   FQN="(anonymous namespace)::CatchTypePublicBases::getFoundHandler", NM="_ZNK12_GLOBAL__N_120CatchTypePublicBases15getFoundHandlerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZNK12_GLOBAL__N_120CatchTypePublicBases15getFoundHandlerEv")
  //</editor-fold>
  public CXXCatchStmt /*P*/ getFoundHandler() /*const*/ {
    return FoundHandler;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CatchTypePublicBases::getFoundHandlerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 3620,
   FQN="(anonymous namespace)::CatchTypePublicBases::getFoundHandlerType", NM="_ZNK12_GLOBAL__N_120CatchTypePublicBases19getFoundHandlerTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZNK12_GLOBAL__N_120CatchTypePublicBases19getFoundHandlerTypeEv")
  //</editor-fold>
  public CanQual<Type> getFoundHandlerType() /*const*/ {
    return new CanQual<Type>(FoundHandlerType);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CatchTypePublicBases::operator()">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 3622,
   FQN="(anonymous namespace)::CatchTypePublicBases::operator()", NM="_ZN12_GLOBAL__N_120CatchTypePublicBasesclEPKN5clang16CXXBaseSpecifierERNS1_11CXXBasePathE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN12_GLOBAL__N_120CatchTypePublicBasesclEPKN5clang16CXXBaseSpecifierERNS1_11CXXBasePathE")
  //</editor-fold>
  public boolean $call(/*const*/ CXXBaseSpecifier /*P*/ S, final CXXBasePath /*&*/ $Prm1) {
    if (S.getAccessSpecifier() == AccessSpecifier.AS_public) {
      CatchHandlerType Check/*J*/= new CatchHandlerType(S.getType(), CheckAgainstPointer);
      final /*const*/ DenseMap<CatchHandlerType, CXXCatchStmt /*P*/> /*&*/ M = TypesToCheck;
      DenseMapIterator<CatchHandlerType, CXXCatchStmt /*P*/ > I = M.find$Const(Check);
      if (I.$noteq(M.end$Const())) {
        FoundHandler = I.$arrow().second;
        FoundHandlerType.$assignMove(Ctx.getCanonicalType(S.getType()));
        return true;
      }
    }
    return false;
  }

  
  @Override public String toString() {
    return "" + "Ctx=" + "[ASTContext]" // NOI18N
              + ", TypesToCheck=" + TypesToCheck // NOI18N
              + ", CheckAgainstPointer=" + CheckAgainstPointer // NOI18N
              + ", FoundHandler=" + FoundHandler // NOI18N
              + ", FoundHandlerType=" + FoundHandlerType; // NOI18N
  }
}
