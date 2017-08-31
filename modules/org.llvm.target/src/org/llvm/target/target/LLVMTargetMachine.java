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
import org.llvm.mc.*;
import org.llvm.ir.*;
import org.llvm.ir.legacy.PassManagerBase;


/// This class describes a target machine that is implemented with the LLVM
/// target-independent code generator.
///
//<editor-fold defaultstate="collapsed" desc="llvm::LLVMTargetMachine">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetMachine.h", line = 281,
 FQN="llvm::LLVMTargetMachine", NM="_ZN4llvm17LLVMTargetMachineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm17LLVMTargetMachineE")
//</editor-fold>
public class LLVMTargetMachine extends /*public*/ TargetMachine implements Destructors.ClassWithDestructor {
/*protected:*/
  // Can only create subclasses.
  //<editor-fold defaultstate="collapsed" desc="llvm::LLVMTargetMachine::LLVMTargetMachine">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetMachine.h", line = 283,
   FQN="llvm::LLVMTargetMachine::LLVMTargetMachine", NM="_ZN4llvm17LLVMTargetMachineC1ERKNS_6TargetENS_9StringRefERKNS_6TripleES4_S4_NS_13TargetOptionsENS_5Reloc5ModelENS_9CodeModel5ModelENS_10CodeGenOpt5LevelE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm17LLVMTargetMachineC1ERKNS_6TargetENS_9StringRefERKNS_6TripleES4_S4_NS_13TargetOptionsENS_5Reloc5ModelENS_9CodeModel5ModelENS_10CodeGenOpt5LevelE")
  //</editor-fold>
  protected LLVMTargetMachine(final /*const*/ Target /*&*/ T, StringRef DataLayoutString, 
      final /*const*/ Triple /*&*/ TargetTriple, StringRef CPU, StringRef FS, 
      TargetOptions Options, Reloc.Model RM, CodeModel.Model CM, 
      CodeGenOpt.Level OL) {
    super(T, DataLayoutString, TargetTriple, CPU, FS, Options);
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::LLVMTargetMachine::initAsmInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetMachine.h", line = 288,
   FQN="llvm::LLVMTargetMachine::initAsmInfo", NM="_ZN4llvm17LLVMTargetMachine11initAsmInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm17LLVMTargetMachine11initAsmInfoEv")
  //</editor-fold>
  protected void initAsmInfo() {
    throw new UnsupportedOperationException("EmptyBody");
  }


/*public:*/
  /// \brief Get a TargetIRAnalysis implementation for the target.
  ///
  /// This analysis will produce a TTI result which uses the common code
  /// generator to answer queries about the IR.
  //<editor-fold defaultstate="collapsed" desc="llvm::LLVMTargetMachine::getTargetIRAnalysis">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetMachine.h", line = 294,
   FQN="llvm::LLVMTargetMachine::getTargetIRAnalysis", NM="_ZN4llvm17LLVMTargetMachine19getTargetIRAnalysisEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm17LLVMTargetMachine19getTargetIRAnalysisEv")
  //</editor-fold>
  @Override public TargetIRAnalysis getTargetIRAnalysis()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
//  /// Create a pass configuration object to be used by addPassToEmitX methods
//  /// for generating a pipeline of CodeGen passes.
//  //<editor-fold defaultstate="collapsed" desc="llvm::LLVMTargetMachine::createPassConfig">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetMachine.h", line = 298,
//   FQN="llvm::LLVMTargetMachine::createPassConfig", NM="_ZN4llvm17LLVMTargetMachine16createPassConfigERNS_6legacy15PassManagerBaseE",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm17LLVMTargetMachine16createPassConfigERNS_6legacy15PassManagerBaseE")
//  //</editor-fold>
//  public /*virtual*/ TargetPassConfig /*P*/ createPassConfig(final PassManagerBase /*&*/ PM) {
//    throw new UnsupportedOperationException("EmptyBody");
//  }


  
//  /// Add passes to the specified pass manager to get the specified file
//  /// emitted.  Typically this will involve several steps of code generation.
//  //<editor-fold defaultstate="collapsed" desc="llvm::LLVMTargetMachine::addPassesToEmitFile">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetMachine.h", line = 302,
//   FQN="llvm::LLVMTargetMachine::addPassesToEmitFile", NM="_ZN4llvm17LLVMTargetMachine19addPassesToEmitFileERNS_6legacy15PassManagerBaseERNS_17raw_pwrite_streamENS_13TargetMachine15CodeGenFileTypeEbPKvS9_S9_PNS_26MachineFunctionInitializerE",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm17LLVMTargetMachine19addPassesToEmitFileERNS_6legacy15PassManagerBaseERNS_17raw_pwrite_streamENS_13TargetMachine15CodeGenFileTypeEbPKvS9_S9_PNS_26MachineFunctionInitializerE")
//  //</editor-fold>
//  @Override public boolean addPassesToEmitFile(final PassManagerBase /*&*/ PM, final raw_pwrite_stream /*&*/ Out, TargetMachine.CodeGenFileType FileType)/* override*/ {
//    return addPassesToEmitFile(PM, Out, FileType, 
//                     true, (/*const*/Object/*void P*/ )null, 
//                     (/*const*/Object/*void P*/ )null, (/*const*/Object/*void P*/ )null, 
//                     (MachineFunctionInitializer /*P*/ )null);
//  }
//  @Override public boolean addPassesToEmitFile(final PassManagerBase /*&*/ PM, final raw_pwrite_stream /*&*/ Out, TargetMachine.CodeGenFileType FileType, 
//                     boolean DisableVerify/*= true*/)/* override*/ {
//    return addPassesToEmitFile(PM, Out, FileType, 
//                     DisableVerify, (/*const*/Object/*void P*/ )null, 
//                     (/*const*/Object/*void P*/ )null, (/*const*/Object/*void P*/ )null, 
//                     (MachineFunctionInitializer /*P*/ )null);
//  }
//  @Override public boolean addPassesToEmitFile(final PassManagerBase /*&*/ PM, final raw_pwrite_stream /*&*/ Out, TargetMachine.CodeGenFileType FileType, 
//                     boolean DisableVerify/*= true*/, /*const*/Object/*void P*/ StartBefore/*= null*/)/* override*/ {
//    return addPassesToEmitFile(PM, Out, FileType, 
//                     DisableVerify, StartBefore, 
//                     (/*const*/Object/*void P*/ )null, (/*const*/Object/*void P*/ )null, 
//                     (MachineFunctionInitializer /*P*/ )null);
//  }
//  @Override public boolean addPassesToEmitFile(final PassManagerBase /*&*/ PM, final raw_pwrite_stream /*&*/ Out, TargetMachine.CodeGenFileType FileType, 
//                     boolean DisableVerify/*= true*/, /*const*/Object/*void P*/ StartBefore/*= null*/, 
//                     /*const*/Object/*void P*/ StartAfter/*= null*/)/* override*/ {
//    return addPassesToEmitFile(PM, Out, FileType, 
//                     DisableVerify, StartBefore, 
//                     StartAfter, (/*const*/Object/*void P*/ )null, 
//                     (MachineFunctionInitializer /*P*/ )null);
//  }
//  @Override public boolean addPassesToEmitFile(final PassManagerBase /*&*/ PM, final raw_pwrite_stream /*&*/ Out, TargetMachine.CodeGenFileType FileType, 
//                     boolean DisableVerify/*= true*/, /*const*/Object/*void P*/ StartBefore/*= null*/, 
//                     /*const*/Object/*void P*/ StartAfter/*= null*/, /*const*/Object/*void P*/ StopAfter/*= null*/)/* override*/ {
//    return addPassesToEmitFile(PM, Out, FileType, 
//                     DisableVerify, StartBefore, 
//                     StartAfter, StopAfter, 
//                     (MachineFunctionInitializer /*P*/ )null);
//  }
//  @Override public boolean addPassesToEmitFile(final PassManagerBase /*&*/ PM, final raw_pwrite_stream /*&*/ Out, TargetMachine.CodeGenFileType FileType, 
//                     boolean DisableVerify/*= true*/, /*const*/Object/*void P*/ StartBefore/*= null*/, 
//                     /*const*/Object/*void P*/ StartAfter/*= null*/, /*const*/Object/*void P*/ StopAfter/*= null*/, 
//                     MachineFunctionInitializer /*P*/ MFInitializer/*= null*/)/* override*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }


  
  /// Add passes to the specified pass manager to get machine code emitted with
  /// the MCJIT. This method returns true if machine code is not supported. It
  /// fills the MCContext Ctx pointer which can be used to build custom
  /// MCStreamer.
  //<editor-fold defaultstate="collapsed" desc="llvm::LLVMTargetMachine::addPassesToEmitMC">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetMachine.h", line = 312,
   FQN="llvm::LLVMTargetMachine::addPassesToEmitMC", NM="_ZN4llvm17LLVMTargetMachine17addPassesToEmitMCERNS_6legacy15PassManagerBaseERPNS_9MCContextERNS_17raw_pwrite_streamEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm17LLVMTargetMachine17addPassesToEmitMCERNS_6legacy15PassManagerBaseERPNS_9MCContextERNS_17raw_pwrite_streamEb")
  //</editor-fold>
  @Override public boolean addPassesToEmitMC(final PassManagerBase /*&*/ PM, final type$ref<MCContext /*P*/ /*&*/> Ctx, 
                   final raw_pwrite_stream /*&*/ OS)/* override*/ {
    return addPassesToEmitMC(PM, Ctx, 
                   OS, 
                   true);
  }
  @Override public boolean addPassesToEmitMC(final PassManagerBase /*&*/ PM, final type$ref<MCContext /*P*/ /*&*/> Ctx, 
                   final raw_pwrite_stream /*&*/ OS, 
                   boolean DisableVerify/*= true*/)/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
//  /// Add MachineModuleInfo pass to pass manager.
//  //<editor-fold defaultstate="collapsed" desc="llvm::LLVMTargetMachine::addMachineModuleInfo">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetMachine.h", line = 317,
//   FQN="llvm::LLVMTargetMachine::addMachineModuleInfo", NM="_ZNK4llvm17LLVMTargetMachine20addMachineModuleInfoERNS_6legacy15PassManagerBaseE",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm17LLVMTargetMachine20addMachineModuleInfoERNS_6legacy15PassManagerBaseE")
//  //</editor-fold>
//  public MachineModuleInfo /*&*/ addMachineModuleInfo(final PassManagerBase /*&*/ PM) /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }


  
//  /// Add MachineFunctionAnalysis pass to pass manager.
//  //<editor-fold defaultstate="collapsed" desc="llvm::LLVMTargetMachine::addMachineFunctionAnalysis">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetMachine.h", line = 320,
//   FQN="llvm::LLVMTargetMachine::addMachineFunctionAnalysis", NM="_ZNK4llvm17LLVMTargetMachine26addMachineFunctionAnalysisERNS_6legacy15PassManagerBaseEPNS_26MachineFunctionInitializerE",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm17LLVMTargetMachine26addMachineFunctionAnalysisERNS_6legacy15PassManagerBaseEPNS_26MachineFunctionInitializerE")
//  //</editor-fold>
//  public void addMachineFunctionAnalysis(final PassManagerBase /*&*/ PM, 
//                            MachineFunctionInitializer /*P*/ MFInitializer) /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }


  //<editor-fold defaultstate="collapsed" desc="llvm::LLVMTargetMachine::~LLVMTargetMachine">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetMachine.h", line = 281,
   FQN="llvm::LLVMTargetMachine::~LLVMTargetMachine", NM="_ZN4llvm17LLVMTargetMachineD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm17LLVMTargetMachineD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
