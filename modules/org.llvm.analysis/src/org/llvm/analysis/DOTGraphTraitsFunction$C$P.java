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

package org.llvm.analysis;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.ir.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.llvm.pass.IrLlvmGlobals.$out_raw_ostream_Value$C;
import static org.llvm.pass.IrLlvmGlobals.succ_begin_BasicBlock$C$P;
import static org.llvm.support.AdtsupportLlvmGlobals.$out_raw_ostream_APInt$C;

//<editor-fold defaultstate="collapsed" desc="llvm::DOTGraphTraits<const Function * >">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CFGPrinter.h", line = 25,
 FQN="llvm::DOTGraphTraits<const Function * >", NM="_ZN4llvm14DOTGraphTraitsIPKNS_8FunctionEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFGPrinter.cpp -nm=_ZN4llvm14DOTGraphTraitsIPKNS_8FunctionEEE")
//</editor-fold>
public class/*struct*/ DOTGraphTraitsFunction$C$P extends /*public*/ DefaultDOTGraphTraits {
  
  //<editor-fold defaultstate="collapsed" desc="llvm::DOTGraphTraits<const Function * >::DOTGraphTraits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CFGPrinter.h", line = 28,
   FQN="llvm::DOTGraphTraits<const Function * >::DOTGraphTraits", NM="_ZN4llvm14DOTGraphTraitsIPKNS_8FunctionEEC1Eb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFGPrinter.cpp -nm=_ZN4llvm14DOTGraphTraitsIPKNS_8FunctionEEC1Eb")
  //</editor-fold>
  public DOTGraphTraitsFunction$C$P() {
    this(false);
  }
  public DOTGraphTraitsFunction$C$P(boolean isSimple/*= false*/) {
    // : DefaultDOTGraphTraits(isSimple) 
    //START JInit
    super(isSimple);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DOTGraphTraits<const Function * >::getGraphName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CFGPrinter.h", line = 30,
   FQN="llvm::DOTGraphTraits<const Function * >::getGraphName", NM="_ZN4llvm14DOTGraphTraitsIPKNS_8FunctionEE12getGraphNameES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFGPrinter.cpp -nm=_ZN4llvm14DOTGraphTraitsIPKNS_8FunctionEE12getGraphNameES3_")
  //</editor-fold>
  public static std.string getGraphName(/*const*/ Function /*P*/ F) {
    return $add_string_T$C$P($add_T$C$P_string(/*KEEP_STR*/"CFG for '", F.getName().str()), /*KEEP_STR*/"' function");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DOTGraphTraits<const Function * >::getSimpleNodeLabel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CFGPrinter.h", line = 34,
   FQN="llvm::DOTGraphTraits<const Function * >::getSimpleNodeLabel", NM="_ZN4llvm14DOTGraphTraitsIPKNS_8FunctionEE18getSimpleNodeLabelEPKNS_10BasicBlockES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFGPrinter.cpp -nm=_ZN4llvm14DOTGraphTraitsIPKNS_8FunctionEE18getSimpleNodeLabelEPKNS_10BasicBlockES3_")
  //</editor-fold>
  public static std.string getSimpleNodeLabel(/*const*/ BasicBlock /*P*/ Node, 
                    /*const*/ Function /*P*/ $Prm1) {
    raw_string_ostream OS = null;
    try {
      if (!Node.getName().empty()) {
        return Node.getName().str();
      }
      
      std.string Str/*J*/= new std.string();
      OS/*J*/= new raw_string_ostream(Str);
      
      Node.printAsOperand(OS, false);
      return new std.string(OS.str());
    } finally {
      if (OS != null) { OS.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DOTGraphTraits<const Function * >::getCompleteNodeLabel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CFGPrinter.h", line = 46,
   FQN="llvm::DOTGraphTraits<const Function * >::getCompleteNodeLabel", NM="_ZN4llvm14DOTGraphTraitsIPKNS_8FunctionEE20getCompleteNodeLabelEPKNS_10BasicBlockES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFGPrinter.cpp -nm=_ZN4llvm14DOTGraphTraitsIPKNS_8FunctionEE20getCompleteNodeLabelEPKNS_10BasicBlockES3_")
  //</editor-fold>
  public static std.string getCompleteNodeLabel(/*const*/ BasicBlock /*P*/ Node, 
                      /*const*/ Function /*P*/ $Prm1) {
    raw_string_ostream OS = null;
    try {
      /*enum ANONYMOUS_INT_CONSTANTS {*/
        final /*uint*/int MaxColumns = 80;
      /*}*/;
      std.string Str/*J*/= new std.string();
      OS/*J*/= new raw_string_ostream(Str);
      if (Node.getName().empty()) {
        Node.printAsOperand(OS, false);
        OS.$out(/*KEEP_STR*/$COLON);
      }
      
      $out_raw_ostream_Value$C(OS, $Deref(Node));
      std.string OutStr = new std.string(OS.str());
      if (OutStr.$at(0) == $$LF) {
        OutStr.erase(OutStr.begin());
      }
      
      // Process string output to make it nicer...
      /*uint*/int ColNum = 0;
      /*uint*/int LastSpace = 0;
      for (/*uint*/int i = 0; i != OutStr.length(); ++i) {
        if (OutStr.$at(i) == $$LF) { // Left justify
          OutStr.$set(i, $$BACK_SLASH);
          OutStr.insert___normal_iterator$template$pointer$string_T(OutStr.begin().$add(i).$add(1), $$l);
          ColNum = 0;
          LastSpace = 0;
        } else if (OutStr.$at(i) == $$SEMI) { // Delete comments!
          /*uint*/int Idx = OutStr.find_T_size_type$_CharT($$LF, i + 1); // Find end of line
          OutStr.erase(OutStr.begin().$add(i), OutStr.begin().$add(Idx));
          --i;
        } else if (ColNum == MaxColumns) { // Wrap lines.
          // Wrap very long names even though we can't find a space.
          if (!(LastSpace != 0)) {
            LastSpace = i;
          }
          OutStr.insert_size_type$_CharT_T$C$P(LastSpace, $("\\l..."));
          ColNum = i - LastSpace;
          LastSpace = 0;
          i += 3; // The loop will advance 'i' again.
        } else {
          ++ColNum;
        }
        if (OutStr.$at(i) == $$SPACE) {
          LastSpace = i;
        }
      }
      return OutStr;
    } finally {
      if (OS != null) { OS.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DOTGraphTraits<const Function * >::getNodeLabel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CFGPrinter.h", line = 91,
   FQN="llvm::DOTGraphTraits<const Function * >::getNodeLabel", NM="_ZN4llvm14DOTGraphTraitsIPKNS_8FunctionEE12getNodeLabelEPKNS_10BasicBlockES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFGPrinter.cpp -nm=_ZN4llvm14DOTGraphTraitsIPKNS_8FunctionEE12getNodeLabelEPKNS_10BasicBlockES3_")
  //</editor-fold>
  public std.string getNodeLabel(/*const*/ BasicBlock /*P*/ Node, 
              /*const*/ Function /*P*/ Graph) {
    if (isSimple()) {
      return DOTGraphTraitsFunction$C$P.getSimpleNodeLabel(Node, Graph);
    } else {
      return DOTGraphTraitsFunction$C$P.getCompleteNodeLabel(Node, Graph);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DOTGraphTraits<const Function * >::getEdgeSourceLabel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CFGPrinter.h", line = 99,
   FQN="llvm::DOTGraphTraits<const Function * >::getEdgeSourceLabel", NM="_ZN4llvm14DOTGraphTraitsIPKNS_8FunctionEE18getEdgeSourceLabelEPKNS_10BasicBlockENS_14TerminatorInst12SuccIteratorIPKS8_S6_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFGPrinter.cpp -nm=_ZN4llvm14DOTGraphTraitsIPKNS_8FunctionEE18getEdgeSourceLabelEPKNS_10BasicBlockENS_14TerminatorInst12SuccIteratorIPKS8_S6_EE")
  //</editor-fold>
  public static std.string getEdgeSourceLabel(/*const*/ BasicBlock /*P*/ Node, 
                    TerminatorInst.SuccIterator</*const*/ TerminatorInst /*P*/ , /*const*/ BasicBlock> I) {
    {
      // Label source of conditional branches with "T" or "F"
      /*const*/ BranchInst /*P*/ BI = dyn_cast_BranchInst(Node.getTerminator$Const());
      if ((BI != null)) {
        if (BI.isConditional()) {
          return new std.string(JD$T$C$P_T2$C$R.INSTANCE, (I.$eq(succ_begin_BasicBlock$C$P(Node))) ? $T : $F);
        }
      }
    }
    {
      
      // Label source of switch edges with the associated value.
      /*const*/ SwitchInst /*P*/ SI = dyn_cast_SwitchInst(Node.getTerminator$Const());
      if ((SI != null)) {
        raw_string_ostream OS = null;
        try {
          /*uint*/int SuccNo = I.getSuccessorIndex();
          if (SuccNo == 0) {
            return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"def");
          }
          
          std.string Str/*J*/= new std.string();
          OS/*J*/= new raw_string_ostream(Str);
          SwitchInst.CaseIteratorT</*const*/ SwitchInst, /*const*/ ConstantInt, /*const*/ BasicBlock> Case = SwitchInst.CaseIteratorT.</*const*/ SwitchInst, /*const*/ ConstantInt, /*const*/ BasicBlock>fromSuccessorIndex(SI, SuccNo);
          $out_raw_ostream_APInt$C(OS, Case.getCaseValue().getValue());
          return new std.string(OS.str());
        } finally {
          if (OS != null) { OS.$destroy(); }
        }
      }
    }
    return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/$EMPTY);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DOTGraphTraits<const Function * >::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CFGPrinter.h", line = 26,
   FQN="llvm::DOTGraphTraits<const Function * >::operator=", NM="_ZN4llvm14DOTGraphTraitsIPKNS_8FunctionEEaSEOS4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFGPrinter.cpp -nm=_ZN4llvm14DOTGraphTraitsIPKNS_8FunctionEEaSEOS4_")
  //</editor-fold>
  public /*inline*/ DOTGraphTraitsFunction$C$P /*&*/ $assignMove(final DOTGraphTraitsFunction$C$P /*&&*/$Prm0) {
    /*J:ToBase*/super.$assignMove($Prm0);
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
