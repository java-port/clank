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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.QualType.*;


//<editor-fold defaultstate="collapsed" desc="static type CallEventStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.staticanalyzer.core.impl.CallEventStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZL10isCallbackN5clang8QualTypeE;_ZL16isPointerToConstN5clang8QualTypeE;_ZL20findPtrToConstParamsRN4llvm8SmallSetIjLj4ESt4lessIjEEERKN5clang4ento9CallEventE;_ZL23isVoidPointerToNonConstN5clang8QualTypeE;_ZL28addParameterValuesToBindingsPKN5clang17StackFrameContextERN4llvm15SmallVectorImplISt4pairINS_4ento3LocENS6_4SValEEEERNS6_11SValBuilderERKNS6_9CallEventENS3_8ArrayRefIPNS_11ParmVarDeclEEE;_ZL35getSyntacticFromForPseudoObjectExprPKN5clang16PseudoObjectExprE; -static-type=CallEventStatics -package=org.clang.staticanalyzer.core.impl")
//</editor-fold>
public final class CallEventStatics {

//<editor-fold defaultstate="collapsed" desc="isCallback">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp", line = 53,
 FQN="isCallback", NM="_ZL10isCallbackN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZL10isCallbackN5clang8QualTypeE")
//</editor-fold>
public static boolean isCallback(QualType T) {
  // If a parameter is a block or a callback, assume it can modify pointer.
  if (T.$arrow().isBlockPointerType()
     || T.$arrow().isFunctionPointerType()
     || T.$arrow().isObjCSelType()) {
    return true;
  }
  
  // Check if a callback is passed inside a struct (for both, struct passed by
  // reference and by value). Dig just one level into the struct for now.
  if (T.$arrow().isAnyPointerType() || T.$arrow().isReferenceType()) {
    T.$assignMove(T.$arrow().getPointeeType());
  }
  {
    
    /*const*/ RecordType /*P*/ RT = T.$arrow().getAsStructureType();
    if ((RT != null)) {
      /*const*/ RecordDecl /*P*/ RD = RT.getDecl();
      for (/*const*/ FieldDecl /*P*/ I : RD.fields()) {
        QualType FieldT = I.getType();
        if (FieldT.$arrow().isBlockPointerType() || FieldT.$arrow().isFunctionPointerType()) {
          return true;
        }
      }
    }
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="isVoidPointerToNonConst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp", line = 77,
 FQN="isVoidPointerToNonConst", NM="_ZL23isVoidPointerToNonConstN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZL23isVoidPointerToNonConstN5clang8QualTypeE")
//</editor-fold>
public static boolean isVoidPointerToNonConst(QualType T) {
  {
    /*const*/ PointerType /*P*/ PT = T.$arrow().getAs(PointerType.class);
    if ((PT != null)) {
      QualType PointeeTy = PT.getPointeeType();
      if (PointeeTy.isConstQualified()) {
        return false;
      }
      return PointeeTy.$arrow().isVoidType();
    } else {
      return false;
    }
  }
}


/// \brief Returns true if a type is a pointer-to-const or reference-to-const
/// with no further indirection.
//<editor-fold defaultstate="collapsed" desc="isPointerToConst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp", line = 131,
 FQN="isPointerToConst", NM="_ZL16isPointerToConstN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZL16isPointerToConstN5clang8QualTypeE")
//</editor-fold>
public static boolean isPointerToConst(QualType Ty) {
  QualType PointeeTy = Ty.$arrow().getPointeeType();
  if (QualType.$eq_QualType$C(PointeeTy, new QualType())) {
    return false;
  }
  if (!PointeeTy.isConstQualified()) {
    return false;
  }
  if (PointeeTy.$arrow().isAnyPointerType()) {
    return false;
  }
  return true;
}


// Try to retrieve the function declaration and find the function parameter
// types which are pointers/references to a non-pointer const.
// We will not invalidate the corresponding argument regions.
//<editor-fold defaultstate="collapsed" desc="findPtrToConstParams">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp", line = 145,
 FQN="findPtrToConstParams", NM="_ZL20findPtrToConstParamsRN4llvm8SmallSetIjLj4ESt4lessIjEEERKN5clang4ento9CallEventE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZL20findPtrToConstParamsRN4llvm8SmallSetIjLj4ESt4lessIjEEERKN5clang4ento9CallEventE")
//</editor-fold>
public static void findPtrToConstParams(final SmallSetUInt /*&*/ PreserveArgs, 
                    final /*const*/ CallEvent /*&*/ Call) {
  /*uint*/int Idx = 0;
  for (mapped_iterator<ParmVarDecl/*P*/, QualType> I = Call.param_type_begin(), 
      E = Call.param_type_end();
       I.$noteq(E); I.$preInc() , ++Idx) {
    if (isPointerToConst(I.$star())) {
      PreserveArgs.insert(Idx);
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="addParameterValuesToBindings">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp", line = 313,
 FQN="addParameterValuesToBindings", NM="_ZL28addParameterValuesToBindingsPKN5clang17StackFrameContextERN4llvm15SmallVectorImplISt4pairINS_4ento3LocENS6_4SValEEEERNS6_11SValBuilderERKNS6_9CallEventENS3_8ArrayRefIPNS_11ParmVarDeclEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZL28addParameterValuesToBindingsPKN5clang17StackFrameContextERN4llvm15SmallVectorImplISt4pairINS_4ento3LocENS6_4SValEEEERNS6_11SValBuilderERKNS6_9CallEventENS3_8ArrayRefIPNS_11ParmVarDeclEEE")
//</editor-fold>
public static void addParameterValuesToBindings(/*const*/ StackFrameContext /*P*/ CalleeCtx, 
                            final SmallVectorImpl<std.pairTypeType<Loc, SVal> > /*&*/ Bindings, 
                            final SValBuilder /*&*/ SVB, 
                            final /*const*/ CallEvent /*&*/ Call, 
                            ArrayRef<ParmVarDecl /*P*/ > parameters) {
  final MemRegionManager /*&*/ MRMgr = SVB.getRegionManager();
  
  // If the function has fewer parameters than the call has arguments, we simply
  // do not bind any values to them.
  /*uint*/int NumArgs = Call.getNumArgs();
  /*uint*/int Idx = 0;
  type$ptr<ParmVarDecl /*P*/ /*P*/> I = $tryClone(parameters.begin());
  type$ptr<ParmVarDecl /*P*/ /*P*/> E = $tryClone(parameters.end());
  for (; $noteq_ptr(I, E) && $less_uint(Idx, NumArgs); I.$preInc() , ++Idx) {
    /*const*/ ParmVarDecl /*P*/ ParamDecl = I.$star();
    assert ((ParamDecl != null)) : "Formal parameter has no decl?";
    
    SVal ArgVal = Call.getArgSVal(Idx);
    if (!ArgVal.isUnknown$SVal()) {
      Loc ParamLoc = SVB.makeLoc(MRMgr.getVarRegion(ParamDecl, CalleeCtx));
      Bindings.push_back(std.make_pair($Clone(ParamLoc), $Clone(ArgVal)));
    }
  }
  // FIXME: Variadic arguments are not handled at all right now.
}

//<editor-fold defaultstate="collapsed" desc="getSyntacticFromForPseudoObjectExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp", line = 760,
 FQN="getSyntacticFromForPseudoObjectExpr", NM="_ZL35getSyntacticFromForPseudoObjectExprPKN5clang16PseudoObjectExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZL35getSyntacticFromForPseudoObjectExprPKN5clang16PseudoObjectExprE")
//</editor-fold>
public static /*const*/ Expr /*P*/ getSyntacticFromForPseudoObjectExpr(/*const*/ PseudoObjectExpr /*P*/ POE) {
  /*const*/ Expr /*P*/ Syntactic = POE.getSyntacticForm$Const();
  {
    
    // This handles the funny case of assigning to the result of a getter.
    // This can happen if the getter returns a non-const reference.
    /*const*/ BinaryOperator /*P*/ BO = dyn_cast_BinaryOperator(Syntactic);
    if ((BO != null)) {
      Syntactic = BO.getLHS();
    }
  }
  
  return Syntactic;
}

} // END OF class CallEventStatics
