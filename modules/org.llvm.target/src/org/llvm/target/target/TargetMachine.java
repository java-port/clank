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

package org.llvm.target.target;

import org.llvm.support.target.Target;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.analysis.*;
import org.llvm.analysis.target.TargetIRAnalysis;
import org.llvm.ir.*;
import org.llvm.ir.java.TargetMachineForward;
import org.llvm.ir.legacy.PassManagerBase;
import org.llvm.mc.*;


//===----------------------------------------------------------------------===//
///
/// Primary interface to the complete machine description for the target
/// machine.  All target-specific information should be accessible through this
/// interface.
///
//<editor-fold defaultstate="collapsed" desc="llvm::TargetMachine">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetMachine.h", line = 66,
 FQN="llvm::TargetMachine", NM="_ZN4llvm13TargetMachineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm13TargetMachineE")
//</editor-fold>
public class TargetMachine implements TargetMachineForward, Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetMachine::TargetMachine">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetMachine.h", line = 67,
   FQN="llvm::TargetMachine::TargetMachine", NM="_ZN4llvm13TargetMachineC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm13TargetMachineC1ERKS0_")
  //</editor-fold>
  protected/*private*/ TargetMachine(final /*const*/ TargetMachine /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetMachine::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetMachine.h", line = 68,
   FQN="llvm::TargetMachine::operator=", NM="_ZN4llvm13TargetMachineaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm13TargetMachineaSERKS0_")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ TargetMachine /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*protected:*/
  // Can only create subclasses.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetMachine::TargetMachine">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetMachine.h", line = 70,
   FQN="llvm::TargetMachine::TargetMachine", NM="_ZN4llvm13TargetMachineC1ERKNS_6TargetENS_9StringRefERKNS_6TripleES4_S4_RKNS_13TargetOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm13TargetMachineC1ERKNS_6TargetENS_9StringRefERKNS_6TripleES4_S4_RKNS_13TargetOptionsE")
  //</editor-fold>
  protected TargetMachine(final /*const*/ Target /*&*/ T, StringRef DataLayoutString, 
      final /*const*/ Triple /*&*/ TargetTriple, StringRef CPU, StringRef FS, 
      final /*const*/ TargetOptions /*&*/ Options) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// The Target that this machine was created for.
  protected final /*const*/ Target /*&*/ TheTarget;
  
  /// DataLayout for the target: keep ABI type size and alignment.
  ///
  /// The DataLayout is created based on the string representation provided
  /// during construction. It is kept here only to avoid reparsing the string
  /// but should not really be used during compilation, because it has an
  /// internal cache that is context specific.
  protected /*const*/ DataLayout DL;
  
  /// Triple string, CPU name, and target feature strings the TargetMachine
  /// instance is created with.
  protected Triple TargetTriple;
  protected std.string TargetCPU;
  protected std.string TargetFS;
  
  protected Reloc.Model RM/* = Reloc::Static*/;
  protected CodeModel.Model CMModel/* = CodeModel::Default*/;
  protected CodeGenOpt.Level OptLevel/* = CodeGenOpt::Default*/;
  
  /// Contains target specific asm information.
  protected /*const*/ MCAsmInfo /*P*/ AsmInfo;
  
  protected /*const*/ MCRegisterInfo /*P*/ MRI;
  protected /*const*/ MCInstrInfo /*P*/ MII;
  protected /*const*/ MCSubtargetInfo /*P*/ STI;
  
  protected /*JBIT unsigned int*/ boolean RequireStructuredCFG /*: 1*/;
  protected /*JBIT unsigned int*/ boolean O0WantsFastISel /*: 1*/;
/*public:*/
  public /*mutable */TargetOptions Options;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetMachine::~TargetMachine">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetMachine.h", line = 108,
   FQN="llvm::TargetMachine::~TargetMachine", NM="_ZN4llvm13TargetMachineD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm13TargetMachineD0Ev")
  //</editor-fold>
  public /*virtual*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetMachine::getTarget">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetMachine.h", line = 110,
   FQN="llvm::TargetMachine::getTarget", NM="_ZNK4llvm13TargetMachine9getTargetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm13TargetMachine9getTargetEv")
  //</editor-fold>
  public /*const*/ Target /*&*/ getTarget() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetMachine::getTargetTriple">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetMachine.h", line = 112,
   FQN="llvm::TargetMachine::getTargetTriple", NM="_ZNK4llvm13TargetMachine15getTargetTripleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm13TargetMachine15getTargetTripleEv")
  //</editor-fold>
  public /*const*/ Triple /*&*/ getTargetTriple() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetMachine::getTargetCPU">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetMachine.h", line = 113,
   FQN="llvm::TargetMachine::getTargetCPU", NM="_ZNK4llvm13TargetMachine12getTargetCPUEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm13TargetMachine12getTargetCPUEv")
  //</editor-fold>
  public StringRef getTargetCPU() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetMachine::getTargetFeatureString">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetMachine.h", line = 114,
   FQN="llvm::TargetMachine::getTargetFeatureString", NM="_ZNK4llvm13TargetMachine22getTargetFeatureStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm13TargetMachine22getTargetFeatureStringEv")
  //</editor-fold>
  public StringRef getTargetFeatureString() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Virtual method implemented by subclasses that returns a reference to that
  /// target's TargetSubtargetInfo-derived member variable.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetMachine::getSubtargetImpl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetMachine.h", line = 118,
   FQN="llvm::TargetMachine::getSubtargetImpl", NM="_ZNK4llvm13TargetMachine16getSubtargetImplERKNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm13TargetMachine16getSubtargetImplERKNS_8FunctionE")
  //</editor-fold>
  public /*virtual*/ /*const*/ TargetSubtargetInfo /*P*/ getSubtargetImpl(final /*const*/ Function /*&*/ $Prm0) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

//  //<editor-fold defaultstate="collapsed" desc="llvm::TargetMachine::getObjFileLowering">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetMachine.h", line = 121,
//   FQN="llvm::TargetMachine::getObjFileLowering", NM="_ZNK4llvm13TargetMachine18getObjFileLoweringEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm13TargetMachine18getObjFileLoweringEv")
//  //</editor-fold>
//  public /*virtual*/ TargetLoweringObjectFile /*P*/ getObjFileLowering() /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }

  
  /// This method returns a pointer to the specified type of
  /// TargetSubtargetInfo.  In debug builds, it verifies that the object being
  /// returned is of the correct type.
  /*template <typename STC> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetMachine::getSubtarget">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetMachine.h", line = 128,
   FQN="llvm::TargetMachine::getSubtarget", NM="Tpl__ZNK4llvm13TargetMachine12getSubtargetERKNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=Tpl__ZNK4llvm13TargetMachine12getSubtargetERKNS_8FunctionE")
  //</editor-fold>
  public </*typename*/ STC> /*const*/ STC /*&*/ getSubtarget(final /*const*/ Function /*&*/ F) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Create a DataLayout.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetMachine::createDataLayout">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetMachine.h", line = 133,
   FQN="llvm::TargetMachine::createDataLayout", NM="_ZNK4llvm13TargetMachine16createDataLayoutEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm13TargetMachine16createDataLayoutEv")
  //</editor-fold>
  public /*const*/ DataLayout createDataLayout() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Test if a DataLayout if compatible with the CodeGen for this target.
  ///
  /// The LLVM Module owns a DataLayout that is used for the target independent
  /// optimizations and code generation. This hook provides a target specific
  /// check on the validity of this DataLayout.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetMachine::isCompatibleDataLayout">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetMachine.h", line = 140,
   FQN="llvm::TargetMachine::isCompatibleDataLayout", NM="_ZNK4llvm13TargetMachine22isCompatibleDataLayoutERKNS_10DataLayoutE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm13TargetMachine22isCompatibleDataLayoutERKNS_10DataLayoutE")
  //</editor-fold>
  public boolean isCompatibleDataLayout(final /*const*/ DataLayout /*&*/ Candidate) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Get the pointer size for this target.
  ///
  /// This is the only time the DataLayout in the TargetMachine is used.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetMachine::getPointerSize">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetMachine.h", line = 147,
   FQN="llvm::TargetMachine::getPointerSize", NM="_ZNK4llvm13TargetMachine14getPointerSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm13TargetMachine14getPointerSizeEv")
  //</editor-fold>
  public /*uint*/int getPointerSize() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Reset the target options based on the function's attributes.
  // FIXME: Remove TargetOptions that affect per-function code generation
  // from TargetMachine.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetMachine::resetTargetOptions">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetMachine.h", line = 152,
   FQN="llvm::TargetMachine::resetTargetOptions", NM="_ZNK4llvm13TargetMachine18resetTargetOptionsERKNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm13TargetMachine18resetTargetOptionsERKNS_8FunctionE")
  //</editor-fold>
  public void resetTargetOptions(final /*const*/ Function /*&*/ F) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Return target specific asm information.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetMachine::getMCAsmInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetMachine.h", line = 155,
   FQN="llvm::TargetMachine::getMCAsmInfo", NM="_ZNK4llvm13TargetMachine12getMCAsmInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm13TargetMachine12getMCAsmInfoEv")
  //</editor-fold>
  public /*const*/ MCAsmInfo /*P*/ getMCAsmInfo() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetMachine::getMCRegisterInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetMachine.h", line = 157,
   FQN="llvm::TargetMachine::getMCRegisterInfo", NM="_ZNK4llvm13TargetMachine17getMCRegisterInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm13TargetMachine17getMCRegisterInfoEv")
  //</editor-fold>
  public /*const*/ MCRegisterInfo /*P*/ getMCRegisterInfo() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetMachine::getMCInstrInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetMachine.h", line = 158,
   FQN="llvm::TargetMachine::getMCInstrInfo", NM="_ZNK4llvm13TargetMachine14getMCInstrInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm13TargetMachine14getMCInstrInfoEv")
  //</editor-fold>
  public /*const*/ MCInstrInfo /*P*/ getMCInstrInfo() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetMachine::getMCSubtargetInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetMachine.h", line = 159,
   FQN="llvm::TargetMachine::getMCSubtargetInfo", NM="_ZNK4llvm13TargetMachine18getMCSubtargetInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm13TargetMachine18getMCSubtargetInfoEv")
  //</editor-fold>
  public /*const*/ MCSubtargetInfo /*P*/ getMCSubtargetInfo() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
//  /// If intrinsic information is available, return it.  If not, return null.
//  //<editor-fold defaultstate="collapsed" desc="llvm::TargetMachine::getIntrinsicInfo">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetMachine.h", line = 162,
//   FQN="llvm::TargetMachine::getIntrinsicInfo", NM="_ZNK4llvm13TargetMachine16getIntrinsicInfoEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm13TargetMachine16getIntrinsicInfoEv")
//  //</editor-fold>
//  public /*virtual*/ /*const*/ TargetIntrinsicInfo /*P*/ getIntrinsicInfo() /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetMachine::requiresStructuredCFG">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetMachine.h", line = 166,
   FQN="llvm::TargetMachine::requiresStructuredCFG", NM="_ZNK4llvm13TargetMachine21requiresStructuredCFGEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm13TargetMachine21requiresStructuredCFGEv")
  //</editor-fold>
  public boolean requiresStructuredCFG() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetMachine::setRequiresStructuredCFG">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetMachine.h", line = 167,
   FQN="llvm::TargetMachine::setRequiresStructuredCFG", NM="_ZN4llvm13TargetMachine24setRequiresStructuredCFGEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm13TargetMachine24setRequiresStructuredCFGEb")
  //</editor-fold>
  public void setRequiresStructuredCFG(boolean Value) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Returns the code generation relocation model. The choices are static, PIC,
  /// and dynamic-no-pic, and target default.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetMachine::getRelocationModel">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetMachine.h", line = 171,
   FQN="llvm::TargetMachine::getRelocationModel", NM="_ZNK4llvm13TargetMachine18getRelocationModelEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm13TargetMachine18getRelocationModelEv")
  //</editor-fold>
  public Reloc.Model getRelocationModel() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Returns the code model. The choices are small, kernel, medium, large, and
  /// target default.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetMachine::getCodeModel">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetMachine.h", line = 175,
   FQN="llvm::TargetMachine::getCodeModel", NM="_ZNK4llvm13TargetMachine12getCodeModelEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm13TargetMachine12getCodeModelEv")
  //</editor-fold>
  public CodeModel.Model getCodeModel() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetMachine::isPositionIndependent">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetMachine.h", line = 177,
   FQN="llvm::TargetMachine::isPositionIndependent", NM="_ZNK4llvm13TargetMachine21isPositionIndependentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm13TargetMachine21isPositionIndependentEv")
  //</editor-fold>
  public boolean isPositionIndependent() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetMachine::shouldAssumeDSOLocal">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetMachine.h", line = 179,
   FQN="llvm::TargetMachine::shouldAssumeDSOLocal", NM="_ZNK4llvm13TargetMachine20shouldAssumeDSOLocalERKNS_6ModuleEPKNS_11GlobalValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm13TargetMachine20shouldAssumeDSOLocalERKNS_6ModuleEPKNS_11GlobalValueE")
  //</editor-fold>
  public boolean shouldAssumeDSOLocal(final /*const*/ Module /*&*/ M, /*const*/ GlobalValue /*P*/ GV) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Returns the TLS model which should be used for the given global variable.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetMachine::getTLSModel">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetMachine.h", line = 182,
   FQN="llvm::TargetMachine::getTLSModel", NM="_ZNK4llvm13TargetMachine11getTLSModelEPKNS_11GlobalValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm13TargetMachine11getTLSModelEPKNS_11GlobalValueE")
  //</editor-fold>
  public TLSModel.Model getTLSModel(/*const*/ GlobalValue /*P*/ GV) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Returns the optimization level: None, Less, Default, or Aggressive.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetMachine::getOptLevel">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetMachine.h", line = 185,
   FQN="llvm::TargetMachine::getOptLevel", NM="_ZNK4llvm13TargetMachine11getOptLevelEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm13TargetMachine11getOptLevelEv")
  //</editor-fold>
  public CodeGenOpt.Level getOptLevel() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \brief Overrides the optimization level.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetMachine::setOptLevel">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetMachine.h", line = 188,
   FQN="llvm::TargetMachine::setOptLevel", NM="_ZN4llvm13TargetMachine11setOptLevelENS_10CodeGenOpt5LevelE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm13TargetMachine11setOptLevelENS_10CodeGenOpt5LevelE")
  //</editor-fold>
  public void setOptLevel(CodeGenOpt.Level Level) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetMachine::setFastISel">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetMachine.h", line = 190,
   FQN="llvm::TargetMachine::setFastISel", NM="_ZN4llvm13TargetMachine11setFastISelEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm13TargetMachine11setFastISelEb")
  //</editor-fold>
  public void setFastISel(boolean Enable) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetMachine::getO0WantsFastISel">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetMachine.h", line = 191,
   FQN="llvm::TargetMachine::getO0WantsFastISel", NM="_ZN4llvm13TargetMachine18getO0WantsFastISelEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm13TargetMachine18getO0WantsFastISelEv")
  //</editor-fold>
  public boolean getO0WantsFastISel() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetMachine::setO0WantsFastISel">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetMachine.h", line = 192,
   FQN="llvm::TargetMachine::setO0WantsFastISel", NM="_ZN4llvm13TargetMachine18setO0WantsFastISelEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm13TargetMachine18setO0WantsFastISelEb")
  //</editor-fold>
  public void setO0WantsFastISel(boolean Enable) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetMachine::shouldPrintMachineCode">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetMachine.h", line = 194,
   FQN="llvm::TargetMachine::shouldPrintMachineCode", NM="_ZNK4llvm13TargetMachine22shouldPrintMachineCodeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm13TargetMachine22shouldPrintMachineCodeEv")
  //</editor-fold>
  public boolean shouldPrintMachineCode() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Returns the default value of asm verbosity.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetMachine::getAsmVerbosityDefault">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetMachine.h", line = 198,
   FQN="llvm::TargetMachine::getAsmVerbosityDefault", NM="_ZNK4llvm13TargetMachine22getAsmVerbosityDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm13TargetMachine22getAsmVerbosityDefaultEv")
  //</editor-fold>
  public boolean getAsmVerbosityDefault() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetMachine::getUniqueSectionNames">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetMachine.h", line = 202,
   FQN="llvm::TargetMachine::getUniqueSectionNames", NM="_ZNK4llvm13TargetMachine21getUniqueSectionNamesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm13TargetMachine21getUniqueSectionNamesEv")
  //</editor-fold>
  public boolean getUniqueSectionNames() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return true if data objects should be emitted into their own section,
  /// corresponds to -fdata-sections.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetMachine::getDataSections">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetMachine.h", line = 206,
   FQN="llvm::TargetMachine::getDataSections", NM="_ZNK4llvm13TargetMachine15getDataSectionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm13TargetMachine15getDataSectionsEv")
  //</editor-fold>
  public boolean getDataSections() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return true if functions should be emitted into their own section,
  /// corresponding to -ffunction-sections.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetMachine::getFunctionSections">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetMachine.h", line = 212,
   FQN="llvm::TargetMachine::getFunctionSections", NM="_ZNK4llvm13TargetMachine19getFunctionSectionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm13TargetMachine19getFunctionSectionsEv")
  //</editor-fold>
  public boolean getFunctionSections() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Get a \c TargetIRAnalysis appropriate for the target.
  ///
  /// This is used to construct the new pass manager's target IR analysis pass,
  /// set up appropriately for this target machine. Even the old pass manager
  /// uses this to answer queries about the IR.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetMachine::getTargetIRAnalysis">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetMachine.h", line = 221,
   FQN="llvm::TargetMachine::getTargetIRAnalysis", NM="_ZN4llvm13TargetMachine19getTargetIRAnalysisEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm13TargetMachine19getTargetIRAnalysisEv")
  //</editor-fold>
  public /*virtual*/ TargetIRAnalysis getTargetIRAnalysis() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Add target-specific function passes that should be run as early as
  /// possible in the optimization pipeline.  Most TargetMachines have no such
  /// passes.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetMachine::addEarlyAsPossiblePasses">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetMachine.h", line = 226,
   FQN="llvm::TargetMachine::addEarlyAsPossiblePasses", NM="_ZN4llvm13TargetMachine24addEarlyAsPossiblePassesERNS_6legacy15PassManagerBaseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm13TargetMachine24addEarlyAsPossiblePassesERNS_6legacy15PassManagerBaseE")
  //</editor-fold>
  public /*virtual*/ void addEarlyAsPossiblePasses(final PassManagerBase /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// These enums are meant to be passed into addPassesToEmitFile to indicate
  /// what type of file to emit, and returned by it to indicate what type of
  /// file could actually be made.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetMachine::CodeGenFileType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetMachine.h", line = 231,
   FQN="llvm::TargetMachine::CodeGenFileType", NM="_ZN4llvm13TargetMachine15CodeGenFileTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm13TargetMachine15CodeGenFileTypeE")
  //</editor-fold>
  public enum CodeGenFileType implements Native.NativeUIntEnum {
    CGFT_AssemblyFile(0),
    CGFT_ObjectFile(CGFT_AssemblyFile.getValue() + 1),
    CGFT_Null(CGFT_ObjectFile.getValue() + 1); // Do not emit any output.

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static CodeGenFileType valueOf(int val) {
      CodeGenFileType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final CodeGenFileType[] VALUES;
      private static final CodeGenFileType[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (CodeGenFileType kind : CodeGenFileType.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new CodeGenFileType[min < 0 ? (1-min) : 0];
        VALUES = new CodeGenFileType[max >= 0 ? (1+max) : 0];
        for (CodeGenFileType kind : CodeGenFileType.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private CodeGenFileType(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  /// Add passes to the specified pass manager to get the specified file
  /// emitted.  Typically this will involve several steps of code generation.
  /// This method should return true if emission of this file type is not
  /// supported, or false on success.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetMachine::addPassesToEmitFile">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetMachine.h", line = 241,
   FQN="llvm::TargetMachine::addPassesToEmitFile", NM="_ZN4llvm13TargetMachine19addPassesToEmitFileERNS_6legacy15PassManagerBaseERNS_17raw_pwrite_streamENS0_15CodeGenFileTypeEbPKvS8_S8_PNS_26MachineFunctionInitializerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm13TargetMachine19addPassesToEmitFileERNS_6legacy15PassManagerBaseERNS_17raw_pwrite_streamENS0_15CodeGenFileTypeEbPKvS8_S8_PNS_26MachineFunctionInitializerE")
  //</editor-fold>
  public /*virtual*/ boolean addPassesToEmitFile(final PassManagerBase /*&*/ $Prm0, final raw_pwrite_stream /*&*/ $Prm1, CodeGenFileType $Prm2) {
    return addPassesToEmitFile($Prm0, $Prm1, $Prm2, 
                     true, (/*const*/Object/*void P*/ )null, 
                     (/*const*/Object/*void P*/ )null, (/*const*/Object/*void P*/ )null, 
                     (Object /*P*/ )null);
  }
  public /*virtual*/ boolean addPassesToEmitFile(final PassManagerBase /*&*/ $Prm0, final raw_pwrite_stream /*&*/ $Prm1, CodeGenFileType $Prm2, 
                     boolean $Prm3/*= true*/) {
    return addPassesToEmitFile($Prm0, $Prm1, $Prm2, 
                     $Prm3, (/*const*/Object/*void P*/ )null, 
                     (/*const*/Object/*void P*/ )null, (/*const*/Object/*void P*/ )null, 
                     (Object /*P*/ )null);
  }
  public /*virtual*/ boolean addPassesToEmitFile(final PassManagerBase /*&*/ $Prm0, final raw_pwrite_stream /*&*/ $Prm1, CodeGenFileType $Prm2, 
                     boolean $Prm3/*= true*/, /*const*/Object/*void P*/ $Prm4/*= null*/) {
    return addPassesToEmitFile($Prm0, $Prm1, $Prm2, 
                     $Prm3, $Prm4, 
                     (/*const*/Object/*void P*/ )null, (/*const*/Object/*void P*/ )null, 
                     (Object /*P*/ )null);
  }
  public /*virtual*/ boolean addPassesToEmitFile(final PassManagerBase /*&*/ $Prm0, final raw_pwrite_stream /*&*/ $Prm1, CodeGenFileType $Prm2, 
                     boolean $Prm3/*= true*/, /*const*/Object/*void P*/ $Prm4/*= null*/, 
                     /*const*/Object/*void P*/ $Prm5/*= null*/) {
    return addPassesToEmitFile($Prm0, $Prm1, $Prm2, 
                     $Prm3, $Prm4, 
                     $Prm5, (/*const*/Object/*void P*/ )null, 
                     (Object /*P*/ )null);
  }
  public /*virtual*/ boolean addPassesToEmitFile(final PassManagerBase /*&*/ $Prm0, final raw_pwrite_stream /*&*/ $Prm1, CodeGenFileType $Prm2, 
                     boolean $Prm3/*= true*/, /*const*/Object/*void P*/ $Prm4/*= null*/, 
                     /*const*/Object/*void P*/ $Prm5/*= null*/, /*const*/Object/*void P*/ $Prm6/*= null*/) {
    return addPassesToEmitFile($Prm0, $Prm1, $Prm2, 
                     $Prm3, $Prm4, 
                     $Prm5, $Prm6, 
                     (Object /*P*/ )null);
  }
  public /*virtual*/ boolean addPassesToEmitFile(final PassManagerBase /*&*/ $Prm0, final raw_pwrite_stream /*&*/ $Prm1, CodeGenFileType $Prm2, 
                     boolean $Prm3/*= true*/, /*const*/Object/*void P*/ $Prm4/*= null*/, 
                     /*const*/Object/*void P*/ $Prm5/*= null*/, /*const*/Object/*void P*/ $Prm6/*= null*/, 
                     Object/*MachineFunctionInitializer*/ /*P*/ $Prm7/*= null*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Add passes to the specified pass manager to get machine code emitted with
  /// the MCJIT. This method returns true if machine code is not supported. It
  /// fills the MCContext Ctx pointer which can be used to build custom
  /// MCStreamer.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetMachine::addPassesToEmitMC">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetMachine.h", line = 254,
   FQN="llvm::TargetMachine::addPassesToEmitMC", NM="_ZN4llvm13TargetMachine17addPassesToEmitMCERNS_6legacy15PassManagerBaseERPNS_9MCContextERNS_17raw_pwrite_streamEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm13TargetMachine17addPassesToEmitMCERNS_6legacy15PassManagerBaseERPNS_9MCContextERNS_17raw_pwrite_streamEb")
  //</editor-fold>
  public /*virtual*/ boolean addPassesToEmitMC(final PassManagerBase /*&*/ $Prm0, final type$ref<MCContext /*P*/ /*&*/> $Prm1, 
                   final raw_pwrite_stream /*&*/ $Prm2) {
    return addPassesToEmitMC($Prm0, $Prm1, 
                   $Prm2, 
                   true);
  }
  public /*virtual*/ boolean addPassesToEmitMC(final PassManagerBase /*&*/ $Prm0, final type$ref<MCContext /*P*/ /*&*/> $Prm1, 
                   final raw_pwrite_stream /*&*/ $Prm2, 
                   boolean $Prm3/*= true*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// True if subtarget inserts the final scheduling pass on its own.
  ///
  /// Branch relaxation, which must happen after block placement, can
  /// on some targets (e.g. SystemZ) expose additional post-RA
  /// scheduling opportunities.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetMachine::targetSchedulesPostRAScheduling">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetMachine.h", line = 265,
   FQN="llvm::TargetMachine::targetSchedulesPostRAScheduling", NM="_ZNK4llvm13TargetMachine31targetSchedulesPostRASchedulingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm13TargetMachine31targetSchedulesPostRASchedulingEv")
  //</editor-fold>
  public /*virtual*/ boolean targetSchedulesPostRAScheduling() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetMachine::getNameWithPrefix">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetMachine.h", line = 267,
   FQN="llvm::TargetMachine::getNameWithPrefix", NM="_ZNK4llvm13TargetMachine17getNameWithPrefixERNS_15SmallVectorImplIcEEPKNS_11GlobalValueERNS_7ManglerEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm13TargetMachine17getNameWithPrefixERNS_15SmallVectorImplIcEEPKNS_11GlobalValueERNS_7ManglerEb")
  //</editor-fold>
  public void getNameWithPrefix(final SmallString/*&*/ Name, /*const*/ GlobalValue /*P*/ GV, 
                   final Mangler /*&*/ Mang) /*const*/ {
    getNameWithPrefix(Name, GV, 
                   Mang, false);
  }
  public void getNameWithPrefix(final SmallString/*&*/ Name, /*const*/ GlobalValue /*P*/ GV, 
                   final Mangler /*&*/ Mang, boolean MayAlwaysUsePrivate/*= false*/) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::TargetMachine::getSymbol">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetMachine.h", line = 269,
   FQN="llvm::TargetMachine::getSymbol", NM="_ZNK4llvm13TargetMachine9getSymbolEPKNS_11GlobalValueERNS_7ManglerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm13TargetMachine9getSymbolEPKNS_11GlobalValueERNS_7ManglerE")
  //</editor-fold>
  public MCSymbol /*P*/ getSymbol(/*const*/ GlobalValue /*P*/ GV, final Mangler /*&*/ Mang) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// True if the target uses physical regs at Prolog/Epilog insertion
  /// time. If true (most machines), all vregs must be allocated before
  /// PEI. If false (virtual-register machines), then callee-save register
  /// spilling and scavenging are not needed or used.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetMachine::usesPhysRegsForPEI">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetMachine.h", line = 275,
   FQN="llvm::TargetMachine::usesPhysRegsForPEI", NM="_ZNK4llvm13TargetMachine18usesPhysRegsForPEIEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm13TargetMachine18usesPhysRegsForPEIEv")
  //</editor-fold>
  public /*virtual*/ boolean usesPhysRegsForPEI() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "TheTarget=" + TheTarget // NOI18N
              + ", DL=" + DL // NOI18N
              + ", TargetTriple=" + TargetTriple // NOI18N
              + ", TargetCPU=" + TargetCPU // NOI18N
              + ", TargetFS=" + TargetFS // NOI18N
              + ", RM=" + RM // NOI18N
              + ", CMModel=" + CMModel // NOI18N
              + ", OptLevel=" + OptLevel // NOI18N
              + ", AsmInfo=" + AsmInfo // NOI18N
              + ", MRI=" + MRI // NOI18N
              + ", MII=" + MII // NOI18N
              + ", STI=" + STI // NOI18N
              + ", RequireStructuredCFG=" + RequireStructuredCFG // NOI18N
              + ", O0WantsFastISel=" + O0WantsFastISel // NOI18N
              + ", Options=" + Options; // NOI18N
  }
}
