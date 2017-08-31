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

package org.llvm.ir;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import static org.clank.support.JavaCleaner.JC$Push;
import static org.clank.support.JavaCleaner.JC$Pop;
import static org.clank.support.JavaCleaner.JC$Top;
import org.clank.support.NativeCallback.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.adt.ADTFunctionPointers.*;
import org.llvm.llvmc.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;
import org.llvm.ir.Metadata.*;
import org.llvm.ir.intrinsic.*;
import static org.llvm.ir.java.IRFunctionPointers.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.llvm.ir.java.IRJavaDifferentiators.*;
import org.llvm.cl.*;
import org.llvm.ir.java.IRJavaDifferentiators.*;
import org.llvm.ir.java.IRMemberPointers.*;
import org.llvm.ir.java.*;
import org.llvm.pass.*;
import org.llvm.support.dwarf.Tag;
import org.llvm.support.sys.SmartRWMutex;
import org.llvm.ir.java.cst_pred_ty_Predicate;
import org.llvm.ir.legacy.PassManagerBase;
import org.llvm.ir.PassManagerGlobals.*;
import org.llvm.ir.java.MDNodeKeyImpl;
import static org.llvm.adt.HashingGlobals.*;
import static org.llvm.ir.impl.OptBisectStatics.*;


/// This class implements a mechanism to disable passes and individual
/// optimizations at compile time based on a command line option
/// (-opt-bisect-limit) in order to perform a bisecting search for
/// optimization-related problems.
//<editor-fold defaultstate="collapsed" desc="llvm::OptBisect">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/OptBisect.h", line = 28,
 FQN="llvm::OptBisect", NM="_ZN4llvm9OptBisectE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/OptBisect.cpp -nm=_ZN4llvm9OptBisectE")
//</editor-fold>
public class OptBisect {
/*public:*/
  /// \brief Default constructor, initializes the OptBisect state based on the
  /// -opt-bisect-limit command line argument.
  ///
  /// By default, bisection is disabled.
  ///
  /// Clients should not instantiate this class directly.  All access should go
  /// through LLVMContext.
  //<editor-fold defaultstate="collapsed" desc="llvm::OptBisect::OptBisect">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/OptBisect.cpp", line = 31,
   FQN="llvm::OptBisect::OptBisect", NM="_ZN4llvm9OptBisectC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/OptBisect.cpp -nm=_ZN4llvm9OptBisectC1Ev")
  //</editor-fold>
  public OptBisect() {
    // : BisectEnabled(false), LastBisectNum(0)
    //START JInit
    /*InClass*/this.BisectEnabled = false;
    /*InClass*/this.LastBisectNum = 0;
    //END JInit
    BisectEnabled = OptBisectStatics.OptBisectLimit.$T() != INT_MAX;
  }


  /// Checks the bisect limit to determine if the specified pass should run.
  ///
  /// This function will immediate return true if bisection is disabled. If the
  /// bisect limit is set to -1, the function will print a message describing
  /// the pass and the bisect number assigned to it and return true.  Otherwise,
  /// the function will print a message with the bisect number assigned to the
  /// pass and indicating whether or not the pass will be run and return true if
  /// the bisect limit has not yet been exceded or false if it has.
  ///
  /// Most passes should not call this routine directly.  Instead, it is called
  /// through a helper routine provided by the pass base class.  For instance,
  /// function passes should call FunctionPass::skipFunction().
  /*template <class UnitT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::OptBisect::shouldRunPass">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/lib/IR/OptBisect.cpp", line = 96,
   FQN="llvm::OptBisect::shouldRunPass", NM="Tpl__ZN4llvm9OptBisect13shouldRunPassEPKNS_4PassERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/OptBisect.cpp -nm=Tpl__ZN4llvm9OptBisect13shouldRunPassEPKNS_4PassERKT_")
  //</editor-fold>
  public </*class*/ UnitT> boolean shouldRunPass(/*const*/ Pass /*P*/ P, final /*const*/ Module /*&*/ U) {
    if (!BisectEnabled) {
      return true;
    }
    return checkPass(new StringRef(P.getPassName()), new StringRef(getDescription(U)));
  }
  public </*class*/ UnitT> boolean shouldRunPass(/*const*/ Pass /*P*/ P, final /*const*/ Function /*&*/ U) {
    if (!BisectEnabled) {
      return true;
    }
    return checkPass(new StringRef(P.getPassName()), new StringRef(getDescription(U)));
  }
  public </*class*/ UnitT> boolean shouldRunPass(/*const*/ Pass /*P*/ P, final /*const*/ BasicBlock /*&*/ U) {
    if (!BisectEnabled) {
      return true;
    }
    return checkPass(new StringRef(P.getPassName()), new StringRef(getDescription(U)));
  }
  public </*class*/ UnitT> boolean shouldRunPass(/*const*/ Pass /*P*/ P, final /*const*/ Loop /*&*/ U) {
    if (!BisectEnabled) {
      return true;
    }
    return checkPass(new StringRef(P.getPassName()), new StringRef(getDescription(U)));
  }
  public </*class*/ UnitT> boolean shouldRunPass(/*const*/ Pass /*P*/ P, final /*const*/ CallGraphSCCBase /*&*/ U) {
    if (!BisectEnabled) {
      return true;
    }
    return checkPass(new StringRef(P.getPassName()), new StringRef(getDescription(U)));
  }


  /// Checks the bisect limit to determine if the optimization described by the
  /// /p Desc argument should run.
  ///
  /// This function will immediate return true if bisection is disabled. If the
  /// bisect limit is set to -1, the function will print a message with the
  /// bisect number assigned to the optimization along with the /p Desc
  /// description and return true.  Otherwise, the function will print a message
  /// with the bisect number assigned to the optimization and indicating whether
  /// or not the pass will be run and return true if the bisect limit has not
  /// yet been exceded or false if it has.
  ///
  /// Passes may call this function to provide more fine grained control over
  /// individual optimizations performed by the pass.  Passes which cannot be
  /// skipped entirely (such as non-optional code generation passes) may still
  /// call this function to control whether or not individual optional
  /// transformations are performed.
  //<editor-fold defaultstate="collapsed" desc="llvm::OptBisect::shouldRunCase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/OptBisect.cpp", line = 112,
   FQN="llvm::OptBisect::shouldRunCase", NM="_ZN4llvm9OptBisect13shouldRunCaseERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/OptBisect.cpp -nm=_ZN4llvm9OptBisect13shouldRunCaseERKNS_5TwineE")
  //</editor-fold>
  public boolean shouldRunCase(final /*const*/ Twine /*&*/ Msg) {
    if (!BisectEnabled) {
      return true;
    }
    int CurFuelNum = ++LastBisectNum;
    boolean ShouldRun = (OptBisectStatics.OptBisectLimit.$T() == -1 || CurFuelNum <= OptBisectStatics.OptBisectLimit.$T());
    OptBisectStatics.printCaseMessage(CurFuelNum, new StringRef(Msg.str()), ShouldRun);
    return ShouldRun;
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::OptBisect::checkPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/OptBisect.cpp", line = 102,
   FQN="llvm::OptBisect::checkPass", NM="_ZN4llvm9OptBisect9checkPassENS_9StringRefES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/OptBisect.cpp -nm=_ZN4llvm9OptBisect9checkPassENS_9StringRefES1_")
  //</editor-fold>
  private boolean checkPass(/*const*/ StringRef PassName,
           /*const*/ StringRef TargetDesc) {
    assert (BisectEnabled);

    int CurBisectNum = ++LastBisectNum;
    boolean ShouldRun = (OptBisectStatics.OptBisectLimit.$T() == -1 || CurBisectNum <= OptBisectStatics.OptBisectLimit.$T());
    OptBisectStatics.printPassMessage(PassName, CurBisectNum, new StringRef(TargetDesc), ShouldRun);
    return ShouldRun;
  }


  private boolean BisectEnabled/* = false*/;
  private /*uint*/int LastBisectNum/* = 0*/;

  @Override public String toString() {
    return "" + "BisectEnabled=" + BisectEnabled // NOI18N
              + ", LastBisectNum=" + LastBisectNum; // NOI18N
  }
}
