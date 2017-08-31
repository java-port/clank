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
package org.clang.analysis.impl;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.ast.java.ArgsAttrBase;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import org.clang.basic.*;
import org.clang.analysis.*;
import org.clang.analysis.analyses.*;
import org.clang.analysis.impl.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.analysis.impl.ThreadSafetyStatics.*;
import org.clang.analysis.analyses.threadSafety.*;
import org.clang.ast.java.ArgAttrBase;


//<editor-fold defaultstate="collapsed" desc="static type ThreadSafetyStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=Tpl__ZL18ClassifyDiagnosticPKT_R_ZTSNSt9enable_ifIXntsr22has_arg_iterator_rangeIT_EE5valueEN4llvm9StringRefEE4typeE;Tpl__ZL18ClassifyDiagnosticPKT_R_ZTSNSt9enable_ifIXsr22has_arg_iterator_rangeIT_EE5valueEN4llvm9StringRefEE4typeE;_ZL12getValueDeclPKN5clang4ExprE;_ZL12neverReturnsPKN5clang8CFGBlockE;_ZL18ClassifyDiagnosticN5clang8QualTypeE;_ZL18ClassifyDiagnosticPKN5clang14CapabilityAttrE;_ZL18ClassifyDiagnosticPKN5clang9ValueDeclE;_ZL21getStaticBooleanValuePN5clang4ExprERb;_ZN12_GLOBAL__N_1L15warnInvalidLockERN5clang12threadSafety19ThreadSafetyHandlerEPKNS0_4ExprEPKNS0_9NamedDeclES6_N4llvm9StringRefE;_ZN12_GLOBAL__N_1L18findBlockLocationsEPN5clang3CFGEPKNS0_16PostOrderCFGViewERSt6vectorINS_12CFGBlockInfoESaIS7_EE; -static-type=ThreadSafetyStatics -package=org.clang.analysis.impl")
//</editor-fold>
public final class ThreadSafetyStatics {


/// Issue a warning about an invalid lock expression
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::warnInvalidLock">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 59,
 FQN="(anonymous namespace)::warnInvalidLock", NM="_ZN12_GLOBAL__N_1L15warnInvalidLockERN5clang12threadSafety19ThreadSafetyHandlerEPKNS0_4ExprEPKNS0_9NamedDeclES6_N4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_1L15warnInvalidLockERN5clang12threadSafety19ThreadSafetyHandlerEPKNS0_4ExprEPKNS0_9NamedDeclES6_N4llvm9StringRefE")
//</editor-fold>
public static void warnInvalidLock(final ThreadSafetyHandler /*&*/ Handler, 
               /*const*/ Expr /*P*/ MutexExp, /*const*/ NamedDecl /*P*/ D, 
               /*const*/ Expr /*P*/ DeclExp, StringRef Kind) {
  SourceLocation Loc/*J*/= new SourceLocation();
  if ((DeclExp != null)) {
    Loc.$assignMove(DeclExp.getExprLoc());
  }
  
  // FIXME: add a note about the attribute location in MutexExp or D
  if (Loc.isValid()) {
    Handler.handleInvalidLockExp(new StringRef(Kind), new SourceLocation(Loc));
  }
}


/// Find the appropriate source locations to use when producing diagnostics for
/// each block in the CFG.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::findBlockLocations">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 771,
 FQN="(anonymous namespace)::findBlockLocations", NM="_ZN12_GLOBAL__N_1L18findBlockLocationsEPN5clang3CFGEPKNS0_16PostOrderCFGViewERSt6vectorINS_12CFGBlockInfoESaIS7_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_1L18findBlockLocationsEPN5clang3CFGEPKNS0_16PostOrderCFGViewERSt6vectorINS_12CFGBlockInfoESaIS7_EE")
//</editor-fold>
public static void findBlockLocations(CFG /*P*/ CFGraph, 
                  /*const*/ PostOrderCFGView /*P*/ SortedGraph, 
                  final std.vector<CFGBlockInfo> /*&*/ BlockInfo) {
  for (/*const*/ CFGBlock /*P*/ CurrBlock : $Deref(SortedGraph)) {
    CFGBlockInfo /*P*/ CurrBlockInfo = $AddrOf(BlockInfo.$at(CurrBlock.getBlockID()));
    {
      
      // Find the source location of the last statement in the block, if the
      // block is not empty.
      /*const*/ Stmt /*P*/ S = CurrBlock.getTerminator$Const().$Stmt$C$P();
      if ((S != null)) {
        CurrBlockInfo.EntryLoc.$assign(CurrBlockInfo.ExitLoc.$assignMove(S.getLocStart()));
      } else {
        for (type$ptr</*const*/ CFGElement /*P*/ > BI = $tryClone(CurrBlock.rbegin$Const()), 
            /*P*/ BE = $tryClone(CurrBlock.rend$Const()); $noteq_ptr(BI, BE); BI.$preInc()) {
          {
            // FIXME: Handle other CFGElement kinds.
            Optional<CFGStmt> CS = BI.$star().getAs(CFGStmt.class);
            if (CS.$bool()) {
              CurrBlockInfo.ExitLoc.$assignMove(CS.$arrow().getStmt().getLocStart());
              break;
            }
          }
        }
      }
    }
    if (CurrBlockInfo.ExitLoc.isValid()) {
      // This block contains at least one statement. Find the source location
      // of the first statement in the block.
      for (std.reverse_iterator</*const*/ CFGElement> BI = CurrBlock.begin$Const(), 
          BE = CurrBlock.end$Const(); $noteq_reverse_iterator$C(BI, BE); BI.$preInc()) {
        {
          // FIXME: Handle other CFGElement kinds.
          Optional<CFGStmt> CS = BI.$arrow().getAs(CFGStmt.class);
          if (CS.$bool()) {
            CurrBlockInfo.EntryLoc.$assignMove(CS.$arrow().getStmt().getLocStart());
            break;
          }
        }
      }
    } else if (CurrBlock.pred_size() == 1 && ((CurrBlock.pred_begin$Const().$star().$CFGBlock$P()) != null)
       && CurrBlock != $AddrOf(CFGraph.getExit())) {
      // The block is empty, and has a single predecessor. Use its exit
      // location.
      CurrBlockInfo.EntryLoc.$assign(CurrBlockInfo.ExitLoc.$assign(
              BlockInfo.$at((CurrBlock.pred_begin$Const().$star()).$arrow().getBlockID()).ExitLoc
          ));
    }
  }
}


/// \brief Gets the value decl pointer from DeclRefExprs or MemberExprs.
//<editor-fold defaultstate="collapsed" desc="getValueDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 1089,
 FQN="getValueDecl", NM="_ZL12getValueDeclPKN5clang4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZL12getValueDeclPKN5clang4ExprE")
//</editor-fold>
public static /*const*/ ValueDecl /*P*/ getValueDecl(/*const*/ Expr /*P*/ Exp) {
  {
    /*const*/ ImplicitCastExpr /*P*/ CE = dyn_cast_ImplicitCastExpr(Exp);
    if ((CE != null)) {
      return getValueDecl(CE.getSubExpr$Const());
    }
  }
  {
    
    /*const*/ DeclRefExpr /*P*/ DR = dyn_cast_DeclRefExpr(Exp);
    if ((DR != null)) {
      return DR.getDecl$Const();
    }
  }
  {
    
    /*const*/ MemberExpr /*P*/ ME = dyn_cast_MemberExpr(Exp);
    if ((ME != null)) {
      return ME.getMemberDecl();
    }
  }
  
  return null;
}

// namespace
//<editor-fold defaultstate="collapsed" desc="ClassifyDiagnostic">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 1119,
 FQN="ClassifyDiagnostic", NM="_ZL18ClassifyDiagnosticPKN5clang14CapabilityAttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZL18ClassifyDiagnosticPKN5clang14CapabilityAttrE")
//</editor-fold>
public static StringRef ClassifyDiagnostic(/*const*/ CapabilityAttr /*P*/ A) {
  return A.getName();
}

//<editor-fold defaultstate="collapsed" desc="ClassifyDiagnostic">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 1123,
 FQN="ClassifyDiagnostic", NM="_ZL18ClassifyDiagnosticN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZL18ClassifyDiagnosticN5clang8QualTypeE")
//</editor-fold>
public static StringRef ClassifyDiagnostic(QualType VDT) {
  {
    // We need to look at the declaration of the type of the value to determine
    // which it is. The type should either be a record or a typedef, or a pointer
    // or reference thereof.
    /*const*/ RecordType /*P*/ RT = VDT.$arrow().getAs$RecordType();
    if ((RT != null)) {
      {
        /*const*/ RecordDecl /*P*/ RD = RT.getDecl();
        if ((RD != null)) {
          {
            /*const*/ CapabilityAttr /*P*/ CA = RD.getAttr(CapabilityAttr.class);
            if ((CA != null)) {
              return ClassifyDiagnostic(CA);
            }
          }
        }
      }
    } else {
      /*const*/ TypedefType /*P*/ TT = VDT.$arrow().getAs$TypedefType();
      if ((TT != null)) {
        {
          /*const*/ TypedefNameDecl /*P*/ TD = TT.getDecl();
          if ((TD != null)) {
            {
              /*const*/ CapabilityAttr /*P*/ CA = TD.getAttr(CapabilityAttr.class);
              if ((CA != null)) {
                return ClassifyDiagnostic(CA);
              }
            }
          }
        }
      } else if (VDT.$arrow().isPointerType() || VDT.$arrow().isReferenceType()) {
        return ClassifyDiagnostic(VDT.$arrow().getPointeeType());
      }
    }
  }
  
  return new StringRef(/*KEEP_STR*/"mutex");
}

//<editor-fold defaultstate="collapsed" desc="ClassifyDiagnostic">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 1141,
 FQN="ClassifyDiagnostic", NM="_ZL18ClassifyDiagnosticPKN5clang9ValueDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZL18ClassifyDiagnosticPKN5clang9ValueDeclE")
//</editor-fold>
public static StringRef ClassifyDiagnostic(/*const*/ ValueDecl /*P*/ VD) {
  assert ((VD != null)) : "No ValueDecl passed";
  
  // The ValueDecl is the declaration of a mutex or role (hopefully).
  return ClassifyDiagnostic(VD.getType());
}

/*template <typename AttrTy> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="ClassifyDiagnostic">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 1149,
 FQN="ClassifyDiagnostic", NM="Tpl__ZL18ClassifyDiagnosticPKT_R_ZTSNSt9enable_ifIXntsr22has_arg_iterator_rangeIT_EE5valueEN4llvm9StringRefEE4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=Tpl__ZL18ClassifyDiagnosticPKT_R_ZTSNSt9enable_ifIXntsr22has_arg_iterator_rangeIT_EE5valueEN4llvm9StringRefEE4typeE")
//</editor-fold>
public static </*typename*/ AttrTy extends ArgAttrBase> /*std::enable_if<!has_arg_iterator_range<AttrTy>::value, StringRef>::type*/StringRef ClassifyDiagnostic$NotHasArgIteratorRange(/*const*/ AttrTy /*P*/ A) {
  {
    /*const*/ ValueDecl /*P*/ VD = getValueDecl(A.getArg());
    if ((VD != null)) {
      return ClassifyDiagnostic(VD);
    }
  }
  return new StringRef($("mutex"));
}

/*template <typename AttrTy> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="ClassifyDiagnostic">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 1158,
 FQN="ClassifyDiagnostic", NM="Tpl__ZL18ClassifyDiagnosticPKT_R_ZTSNSt9enable_ifIXsr22has_arg_iterator_rangeIT_EE5valueEN4llvm9StringRefEE4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=Tpl__ZL18ClassifyDiagnosticPKT_R_ZTSNSt9enable_ifIXsr22has_arg_iterator_rangeIT_EE5valueEN4llvm9StringRefEE4typeE")
//</editor-fold>
public static </*typename*/ AttrTy extends ArgsAttrBase> /*std::enable_if<has_arg_iterator_range<AttrTy>::value, StringRef>::type*/StringRef ClassifyDiagnostic$HasArgIteratorRange(/*const*/ AttrTy /*P*/ A) {
  for (Expr /*const*/ /*P*/ Arg : A.args()) {
    {
      /*const*/ ValueDecl /*P*/ VD = getValueDecl(Arg);
      if ((VD != null)) {
        return ClassifyDiagnostic(VD);
      }
    }
  }
  return new StringRef($("mutex"));
}

//<editor-fold defaultstate="collapsed" desc="getStaticBooleanValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 1308,
 FQN="getStaticBooleanValue", NM="_ZL21getStaticBooleanValuePN5clang4ExprERb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZL21getStaticBooleanValuePN5clang4ExprERb")
//</editor-fold>
public static boolean getStaticBooleanValue(Expr /*P*/ E, final bool$ref/*bool &*/ TCond) {
  if (isa_CXXNullPtrLiteralExpr(E) || isa_GNUNullExpr(E)) {
    TCond.$set(false);
    return true;
  } else {
    CXXBoolLiteralExpr /*P*/ BLE = dyn_cast_CXXBoolLiteralExpr(E);
    if ((BLE != null)) {
      TCond.$set(BLE.getValue());
      return true;
    } else {
      IntegerLiteral /*P*/ ILE = dyn_cast_IntegerLiteral(E);
      if ((ILE != null)) {
        TCond.$set(ILE.getValue().getBoolValue());
        return true;
      } else {
        ImplicitCastExpr /*P*/ CE = dyn_cast_ImplicitCastExpr(E);
        if ((CE != null)) {
          return getStaticBooleanValue(CE.getSubExpr(), TCond);
        }
      }
    }
  }
  return false;
}


// Return true if block B never continues to its successors.
//<editor-fold defaultstate="collapsed" desc="neverReturns">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 2068,
 FQN="neverReturns", NM="_ZL12neverReturnsPKN5clang8CFGBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZL12neverReturnsPKN5clang8CFGBlockE")
//</editor-fold>
public static boolean neverReturns(/*const*/ CFGBlock /*P*/ B) {
  if (B.hasNoReturnElement()) {
    return true;
  }
  if (B.empty()) {
    return false;
  }
  
  CFGElement Last = B.back();
  {
    Optional<CFGStmt> S = Last.getAs(CFGStmt.class);
    if (S.$bool()) {
      if (isa_CXXThrowExpr(S.$arrow().getStmt())) {
        return true;
      }
    }
  }
  return false;
}

} // END OF class ThreadSafetyStatics
