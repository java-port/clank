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

package org.llvm.pass;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.ir.java.*;


//===---------------------------------------------------------------------------
/// PassInfo class - An instance of this class exists for every pass known by
/// the system, and can be obtained from a live Pass by calling its
/// getPassInfo() method.  These objects are set up by the RegisterPass<>
/// template.
///
//<editor-fold defaultstate="collapsed" desc="llvm::PassInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/PassInfo.h", line = 30,
 FQN="llvm::PassInfo", NM="_ZN4llvm8PassInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm8PassInfoE")
//</editor-fold>
public class PassInfo implements Destructors.ClassWithDestructor {
/*public:*/
  // JAVA: typedef Pass *(*NormalCtor_t)()
//  public final class NormalCtor_t extends NormalCtor_t{ };
  // JAVA: typedef Pass *(*TargetMachineCtor_t)(TargetMachine *)
//  public final class TargetMachineCtor_t extends TargetMachineCtor_t{ };
/*private:*/
  private /*const*/char$ptr/*char P*//*const*/ PassName; // Nice name for Pass
  private /*const*/char$ptr/*char P*//*const*/ PassArgument; // Command Line argument to run this pass
  private final/*const*/Class<? extends Pass>/*void P*/ PassID;
  private /*const*/boolean IsCFGOnlyPass; // Pass only looks at the CFG.
  private /*const*/boolean IsAnalysis; // True if an analysis pass.
  private /*const*/boolean IsAnalysisGroup; // True if an analysis group.
  private std.vector</*const*/ PassInfo /*P*/ > ItfImpl; // Interfaces implemented by this pass
  
  private NormalCtor_t NormalCtor;
  private TargetMachineCtor_t TargetMachineCtor;
/*public:*/
  /// PassInfo ctor - Do not call this directly, this should only be invoked
  /// through RegisterPass.
  //<editor-fold defaultstate="collapsed" desc="llvm::PassInfo::PassInfo">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/include/llvm/PassInfo.h", line = 50,
   FQN="llvm::PassInfo::PassInfo", NM="_ZN4llvm8PassInfoC1EPKcS2_PKvPFPNS_4PassEvEbbPFS6_PNS_13TargetMachineEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm8PassInfoC1EPKcS2_PKvPFPNS_4PassEvEbbPFS6_PNS_13TargetMachineEE")
  //</editor-fold>
  public PassInfo(/*const*/char$ptr/*char P*/ name, /*const*/char$ptr/*char P*/ arg, /*const*/Object/*void P*/ pi, 
      NormalCtor_t normal, boolean isCFGOnly, boolean is_analysis) {
    this(name, arg, pi, 
      normal, isCFGOnly, is_analysis, 
      (TargetMachineCtor_t)null);
  }
  public PassInfo(/*const*/char$ptr/*char P*/ name, /*const*/char$ptr/*char P*/ arg, /*const*/Object/*void P*/ pi, 
      NormalCtor_t normal, boolean isCFGOnly, boolean is_analysis, 
      TargetMachineCtor_t machine/*= null*/) {
    // : PassName(name), PassArgument(arg), PassID(pi), IsCFGOnlyPass(isCFGOnly), IsAnalysis(is_analysis), IsAnalysisGroup(false), ItfImpl(), NormalCtor(normal), TargetMachineCtor(machine) 
    //START JInit
    this.PassName = $tryClone(name);
    this.PassArgument = $tryClone(arg);
    this.PassID = (Class)pi;
    this.IsCFGOnlyPass = isCFGOnly;
    this.IsAnalysis = is_analysis;
    this.IsAnalysisGroup = false;
    this.ItfImpl = new std.vector</*const*/ PassInfo /*P*/ >((/*const*/ PassInfo /*P*/ )null);
    this.NormalCtor = normal;
    this.TargetMachineCtor = machine;
    //END JInit
    assert Pass.class.isAssignableFrom((Class)this.PassID) : "Expected child of Pass: " + this.PassID;
  }

  /// PassInfo ctor - Do not call this directly, this should only be invoked
  /// through RegisterPass. This version is for use by analysis groups; it
  /// does not auto-register the pass.
  //<editor-fold defaultstate="collapsed" desc="llvm::PassInfo::PassInfo">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/include/llvm/PassInfo.h", line = 59,
   FQN="llvm::PassInfo::PassInfo", NM="_ZN4llvm8PassInfoC1EPKcPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm8PassInfoC1EPKcPKv")
  //</editor-fold>
  public PassInfo(/*const*/char$ptr/*char P*/ name, /*const*/Object/*void P*/ pi) {
    // : PassName(name), PassArgument(""), PassID(pi), IsCFGOnlyPass(false), IsAnalysis(false), IsAnalysisGroup(true), ItfImpl(), NormalCtor(null), TargetMachineCtor(null) 
    //START JInit
    this.PassName = $tryClone(name);
    this.PassArgument = $tryClone($EMPTY);
    this.PassID = (Class)pi;
    this.IsCFGOnlyPass = false;
    this.IsAnalysis = false;
    this.IsAnalysisGroup = true;
    this.ItfImpl = new std.vector</*const*/ PassInfo /*P*/ >((/*const*/ PassInfo /*P*/ )null);
    this.NormalCtor = null;
    this.TargetMachineCtor = null;
    //END JInit
    assert Pass.class.isAssignableFrom((Class)this.PassID) : "Expected child of Pass: " + this.PassID;
  }

  
  /// getPassName - Return the friendly name for the pass, never returns null
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::PassInfo::getPassName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/PassInfo.h", line = 66,
   FQN="llvm::PassInfo::getPassName", NM="_ZNK4llvm8PassInfo11getPassNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZNK4llvm8PassInfo11getPassNameEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getPassName() /*const*/ {
    return PassName;
  }

  
  /// getPassArgument - Return the command line option that may be passed to
  /// 'opt' that will cause this pass to be run.  This will return null if there
  /// is no argument.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::PassInfo::getPassArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/PassInfo.h", line = 72,
   FQN="llvm::PassInfo::getPassArgument", NM="_ZNK4llvm8PassInfo15getPassArgumentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZNK4llvm8PassInfo15getPassArgumentEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getPassArgument() /*const*/ {
    return PassArgument;
  }

  
  /// getTypeInfo - Return the id object for the pass...
  /// TODO : Rename
  //<editor-fold defaultstate="collapsed" desc="llvm::PassInfo::getTypeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/PassInfo.h", line = 76,
   FQN="llvm::PassInfo::getTypeInfo", NM="_ZNK4llvm8PassInfo11getTypeInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZNK4llvm8PassInfo11getTypeInfoEv")
  //</editor-fold>
  public /*const*/Object/*void P*/ getTypeInfo() /*const*/ {
    return PassID;
  }

  
  /// Return true if this PassID implements the specified ID pointer.
  //<editor-fold defaultstate="collapsed" desc="llvm::PassInfo::isPassID">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/include/llvm/PassInfo.h", line = 79,
   FQN="llvm::PassInfo::isPassID", NM="_ZNK4llvm8PassInfo8isPassIDEPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZNK4llvm8PassInfo8isPassIDEPKv")
  //</editor-fold>
  public boolean isPassID(/*const*/Object/*void P*/ IDPtr) /*const*/ {
    assert Pass.class.isAssignableFrom((Class)IDPtr) : "Expected child of Pass: " + IDPtr;
    return PassID == IDPtr;
  }

  
  /// isAnalysisGroup - Return true if this is an analysis group, not a normal
  /// pass.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::PassInfo::isAnalysisGroup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/PassInfo.h", line = 84,
   FQN="llvm::PassInfo::isAnalysisGroup", NM="_ZNK4llvm8PassInfo15isAnalysisGroupEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZNK4llvm8PassInfo15isAnalysisGroupEv")
  //</editor-fold>
  public boolean isAnalysisGroup() /*const*/ {
    return IsAnalysisGroup;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PassInfo::isAnalysis">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/PassInfo.h", line = 85,
   FQN="llvm::PassInfo::isAnalysis", NM="_ZNK4llvm8PassInfo10isAnalysisEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZNK4llvm8PassInfo10isAnalysisEv")
  //</editor-fold>
  public boolean isAnalysis() /*const*/ {
    return IsAnalysis;
  }

  
  /// isCFGOnlyPass - return true if this pass only looks at the CFG for the
  /// function.
  //<editor-fold defaultstate="collapsed" desc="llvm::PassInfo::isCFGOnlyPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/PassInfo.h", line = 89,
   FQN="llvm::PassInfo::isCFGOnlyPass", NM="_ZNK4llvm8PassInfo13isCFGOnlyPassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZNK4llvm8PassInfo13isCFGOnlyPassEv")
  //</editor-fold>
  public boolean isCFGOnlyPass() /*const*/ {
    return IsCFGOnlyPass;
  }

  
  /// getNormalCtor - Return a pointer to a function, that when called, creates
  /// an instance of the pass and returns it.  This pointer may be null if there
  /// is no default constructor for the pass.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::PassInfo::getNormalCtor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/PassInfo.h", line = 95,
   FQN="llvm::PassInfo::getNormalCtor", NM="_ZNK4llvm8PassInfo13getNormalCtorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZNK4llvm8PassInfo13getNormalCtorEv")
  //</editor-fold>
  public NormalCtor_t getNormalCtor() /*const*/ {
    return NormalCtor;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PassInfo::setNormalCtor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/PassInfo.h", line = 98,
   FQN="llvm::PassInfo::setNormalCtor", NM="_ZN4llvm8PassInfo13setNormalCtorEPFPNS_4PassEvE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm8PassInfo13setNormalCtorEPFPNS_4PassEvE")
  //</editor-fold>
  public void setNormalCtor(NormalCtor_t Ctor) {
    NormalCtor = Ctor;
  }

  
  /// getTargetMachineCtor - Return a pointer to a function, that when called
  /// with a TargetMachine, creates an instance of the pass and returns it.
  /// This pointer may be null if there is no constructor with a TargetMachine
  /// for the pass.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::PassInfo::getTargetMachineCtor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/PassInfo.h", line = 107,
   FQN="llvm::PassInfo::getTargetMachineCtor", NM="_ZNK4llvm8PassInfo20getTargetMachineCtorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZNK4llvm8PassInfo20getTargetMachineCtorEv")
  //</editor-fold>
  public TargetMachineCtor_t getTargetMachineCtor() /*const*/ {
    return TargetMachineCtor;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PassInfo::setTargetMachineCtor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/PassInfo.h", line = 108,
   FQN="llvm::PassInfo::setTargetMachineCtor", NM="_ZN4llvm8PassInfo20setTargetMachineCtorEPFPNS_4PassEPNS_13TargetMachineEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm8PassInfo20setTargetMachineCtorEPFPNS_4PassEPNS_13TargetMachineEE")
  //</editor-fold>
  public void setTargetMachineCtor(TargetMachineCtor_t Ctor) {
    TargetMachineCtor = Ctor;
  }

  
  /// createPass() - Use this method to create an instance of this pass.
  //<editor-fold defaultstate="collapsed" desc="llvm::PassInfo::createPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/PassInfo.h", line = 113,
   FQN="llvm::PassInfo::createPass", NM="_ZNK4llvm8PassInfo10createPassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZNK4llvm8PassInfo10createPassEv")
  //</editor-fold>
  public Pass /*P*/ createPass() /*const*/ {
    assert ((!isAnalysisGroup() || (NormalCtor != null))) : "No default implementation found for analysis group!";
    assert ((NormalCtor != null)) : "Cannot call createPass on PassInfo without default ctor!";
    return NormalCtor.$call();
  }

  
  /// addInterfaceImplemented - This method is called when this pass is
  /// registered as a member of an analysis group with the RegisterAnalysisGroup
  /// template.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::PassInfo::addInterfaceImplemented">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/PassInfo.h", line = 125,
   FQN="llvm::PassInfo::addInterfaceImplemented", NM="_ZN4llvm8PassInfo23addInterfaceImplementedEPKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm8PassInfo23addInterfaceImplementedEPKS0_")
  //</editor-fold>
  public void addInterfaceImplemented(/*const*/ PassInfo /*P*/ ItfPI) {
    ItfImpl.push_back_T$C$R(ItfPI);
  }

  
  /// getInterfacesImplemented - Return a list of all of the analysis group
  /// interfaces implemented by this pass.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::PassInfo::getInterfacesImplemented">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/PassInfo.h", line = 132,
   FQN="llvm::PassInfo::getInterfacesImplemented", NM="_ZNK4llvm8PassInfo24getInterfacesImplementedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZNK4llvm8PassInfo24getInterfacesImplementedEv")
  //</editor-fold>
  public /*const*/std.vector</*const*/ PassInfo /*P*/ > /*&*/ getInterfacesImplemented() /*const*/ {
    return ItfImpl;
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::PassInfo::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/PassInfo.h", line = 137,
   FQN="llvm::PassInfo::operator=", NM="_ZN4llvm8PassInfoaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm8PassInfoaSERKS0_")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ PassInfo /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::PassInfo::PassInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/PassInfo.h", line = 138,
   FQN="llvm::PassInfo::PassInfo", NM="_ZN4llvm8PassInfoC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm8PassInfoC1ERKS0_")
  //</editor-fold>
  protected/*private*/ PassInfo(final /*const*/ PassInfo /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::PassInfo::~PassInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/PassInfo.h", line = 30,
   FQN="llvm::PassInfo::~PassInfo", NM="_ZN4llvm8PassInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm8PassInfoD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    ItfImpl.$destroy();
    //END JDestroy
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @FunctionalInterface
  public static interface NormalCtor_t {
    Pass $call();
  }
  
  @FunctionalInterface
  public static interface TargetMachineCtor_t {
    Pass $call(TargetMachineForward targetMachine);
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "PassName=" + PassName // NOI18N
              + ", PassArgument=" + PassArgument // NOI18N
              + ", PassID=" + PassID.getName() // NOI18N
              + ", IsCFGOnlyPass=" + IsCFGOnlyPass // NOI18N
              + ", IsAnalysis=" + IsAnalysis // NOI18N
              + ", IsAnalysisGroup=" + IsAnalysisGroup // NOI18N
              + ", ItfImpl=" + ItfImpl // NOI18N
              + ", NormalCtor=" + NormalCtor // NOI18N
              + ", TargetMachineCtor=" + TargetMachineCtor; // NOI18N
  }
}
