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
package org.clang.staticanalyzer.core.impl;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.analysis.java.AnalysisRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type MemRegionStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZL15isImmediateBasePKN5clang13CXXRecordDeclES2_;_ZL16isValidBaseClassPKN5clang13CXXRecordDeclEPKNS_4ento16TypedValueRegionEb;_ZL37getStackOrCaptureRegionForDeclContextPKN5clang15LocationContextEPKNS_11DeclContextEPKNS_7VarDeclE; -static-type=MemRegionStatics -package=org.clang.staticanalyzer.core.impl")
//</editor-fold>
public final class MemRegionStatics {


/// Look through a chain of LocationContexts to either find the
/// StackFrameContext that matches a DeclContext, or find a VarRegion
/// for a variable captured by a block.
//<editor-fold defaultstate="collapsed" desc="getStackOrCaptureRegionForDeclContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 793,
 FQN="getStackOrCaptureRegionForDeclContext", NM="_ZL37getStackOrCaptureRegionForDeclContextPKN5clang15LocationContextEPKNS_11DeclContextEPKNS_7VarDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZL37getStackOrCaptureRegionForDeclContextPKN5clang15LocationContextEPKNS_11DeclContextEPKNS_7VarDeclE")
//</editor-fold>
public static PointerUnion</*const*/ StackFrameContext /*P*/ , /*const*/ VarRegion /*P*/ > getStackOrCaptureRegionForDeclContext(/*const*/ LocationContext /*P*/ LC, 
                                     /*const*/ DeclContext /*P*/ DC, 
                                     /*const*/ VarDecl /*P*/ VD) {
  while ((LC != null)) {
    {
      /*const*/ StackFrameContext /*P*/ SFC = dyn_cast_StackFrameContext(LC);
      if ((SFC != null)) {
        if (cast_DeclContext(SFC.getDecl()) == DC) {
          return new PointerUnion</*const*/ StackFrameContext /*P*/ , /*const*/ VarRegion /*P*/ >(JD$T.INSTANCE, /*const*/ StackFrameContext /*P*/.class, SFC);
        }
      }
    }
    {
      /*const*/ BlockInvocationContext /*P*/ BC = dyn_cast_BlockInvocationContext(LC);
      if ((BC != null)) {
        /*const*/ BlockDataRegion /*P*/ BR = ((/*static_cast*//*const*/ BlockDataRegion /*P*/ )(BC.getContextData()));
        // FIXME: This can be made more efficient.
        for (BlockDataRegion.referenced_vars_iterator I = BR.referenced_vars_begin(), 
            E = BR.referenced_vars_end(); I.$noteq(E); I.$preInc()) {
          {
            /*const*/ VarRegion /*P*/ VR = dyn_cast_VarRegion(I.getOriginalRegion());
            if ((VR != null)) {
              if (VR.getDecl() == VD) {
                return new PointerUnion</*const*/ StackFrameContext /*P*/ , /*const*/ VarRegion /*P*/ >(JD$T1.INSTANCE, /*const*/ VarRegion /*P*/.class, cast_VarRegion(I.getCapturedRegion()));
              }
            }
          }
        }
      }
    }
    
    LC = LC.getParent();
  }
  return new PointerUnion</*const*/ StackFrameContext /*P*/ , /*const*/ VarRegion /*P*/ >(JD$T.INSTANCE, /*const*/ StackFrameContext /*P*/.class, (/*const*/ StackFrameContext /*P*/ )(/*const*/ StackFrameContext /*P*/ )null);
}


/// Checks whether \p BaseClass is a valid virtual or direct non-virtual base
/// class of the type of \p Super.
//<editor-fold defaultstate="collapsed" desc="isValidBaseClass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 1025,
 FQN="isValidBaseClass", NM="_ZL16isValidBaseClassPKN5clang13CXXRecordDeclEPKNS_4ento16TypedValueRegionEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZL16isValidBaseClassPKN5clang13CXXRecordDeclEPKNS_4ento16TypedValueRegionEb")
//</editor-fold>
public static boolean isValidBaseClass(/*const*/ CXXRecordDecl /*P*/ BaseClass, 
                /*const*/ TypedValueRegion /*P*/ Super, 
                boolean IsVirtual) {
  BaseClass = BaseClass.getCanonicalDecl$Const();
  
  /*const*/ CXXRecordDecl /*P*/ Class = Super.getValueType().$arrow().getAsCXXRecordDecl();
  if (!(Class != null)) {
    return true;
  }
  if (IsVirtual) {
    return Class.isVirtuallyDerivedFrom(BaseClass);
  }
  
  for (final /*const*/ CXXBaseSpecifier /*&*/ I : Class.bases$Const()) {
    if (I.getType().$arrow().getAsCXXRecordDecl().getCanonicalDecl() == BaseClass) {
      return true;
    }
  }
  
  return false;
}


/// Returns true if \p Base is an immediate base class of \p Child
//<editor-fold defaultstate="collapsed" desc="isImmediateBase">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 1232,
 FQN="isImmediateBase", NM="_ZL15isImmediateBasePKN5clang13CXXRecordDeclES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZL15isImmediateBasePKN5clang13CXXRecordDeclES2_")
//</editor-fold>
public static boolean isImmediateBase(/*const*/ CXXRecordDecl /*P*/ Child, 
               /*const*/ CXXRecordDecl /*P*/ Base) {
  assert ((Child != null)) : "Child must not be null";
  // Note that we do NOT canonicalize the base class here, because
  // ASTRecordLayout doesn't either. If that leads us down the wrong path,
  // so be it; at least we won't crash.
  for (final /*const*/ CXXBaseSpecifier /*&*/ I : Child.bases$Const()) {
    if (I.getType().$arrow().getAsCXXRecordDecl() == Base) {
      return true;
    }
  }
  
  return false;
}

} // END OF class MemRegionStatics
