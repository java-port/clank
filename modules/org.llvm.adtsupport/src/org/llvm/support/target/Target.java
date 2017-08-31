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

package org.llvm.support.target;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.llvm.mc.*;
import org.llvm.mc.mcparser.*;
import org.llvm.support.CodeGenOpt;
import org.llvm.support.CodeModel;
import org.llvm.support.Reloc;
import org.llvm.support.formatted_raw_ostream;
import org.llvm.support.raw_pwrite_stream;


/// Target - Wrapper for Target specific information.
///
/// For registration purposes, this is a POD type so that targets can be
/// registered without the use of static constructors.
///
/// Targets should implement a single global instance of this class (which
/// will be zero initialized), and pass that instance to the TargetRegistry as
/// part of their initialization.
//<editor-fold defaultstate="collapsed" desc="llvm::Target">
@Converted(kind = Converted.Kind.DUMMY, source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 87,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", old_line = 76,
 FQN = "llvm::Target", NM = "_ZN4llvm6TargetE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZN4llvm6TargetE")
//</editor-fold>
public class Target {
/*public:*/
  /*friend  struct TargetRegistry*/;
  public static interface DiagHandlerTy extends ADTFunctionPointers.DiagHandlerTy {};
  public static interface TripleMatchQualityFnTy  {};
  
  @FunctionalInterface public static interface ArchMatchFnTy { boolean $call(Triple.ArchType target); };
  public static interface MCAdjustCodeGenOptsFnTy   {};
  public static interface MCAsmInfoCtorFnTy         {};
  public static interface MCCodeGenInfoCtorFnTy     {};
  public static interface MCInstrInfoCtorFnTy       {};
  public static interface MCInstrAnalysisCtorFnTy   {};
  public static interface MCRegInfoCtorFnTy         {};
  public static interface MCSubtargetInfoCtorFnTy   {};
  public static interface TargetMachineCtorTy       {};
  public static interface AsmPrinterCtorTy          {};
  public static interface MCAsmBackendCtorTy        {};
  public static interface MCAsmParserCtorTy         {};
  public static interface MCDisassemblerCtorTy      {};
  public static interface MCInstPrinterCtorTy       {};
  public static interface MCCodeEmitterCtorTy       {};
  public static interface MCObjectStreamerCtorTy    {};
  public static interface AsmStreamerCtorTy         {};
  public static interface MCRelocationInfoCtorTy    {};
  public static interface MCSymbolizerCtorTy        {};  
  public static interface COFFStreamerCtorTy        {};
  public static interface MachOStreamerCtorTy       {};
  public static interface ELFStreamerCtorTy         {};
  public static interface NullTargetStreamerCtorTy  {};
  public static interface AsmTargetStreamerCtorTy   {};
  public static interface ObjectTargetStreamerCtorTy{};
  /*typedef unsigned int (*TripleMatchQualityFnTy)(const std::string &) __attribute__((cdecl))*/;
  
  /*typedef MCAsmInfo *(*MCAsmInfoCtorFnTy)(const MCRegisterInfo &, StringRef) __attribute__((cdecl))*/
//  public final class MCAsmInfoCtorFnTy extends MCAsmInfo * (/*P*/ )(/*const*/MCRegisterInfo /*&*/ , StringRef)/* __attribute__((cdecl))*/{ };
  /*typedef MCCodeGenInfo *(*MCCodeGenInfoCtorFnTy)(StringRef, Reloc::Model, CodeModel::Model, CodeGenOpt::Level) __attribute__((cdecl))*/
//  public final class MCCodeGenInfoCtorFnTy extends MCCodeGenInfo * (/*P*/ )(StringRef, Reloc.Model, CodeModel.Model, CodeGenOpt.Level)/* __attribute__((cdecl))*/{ };
  /*typedef MCInstrInfo *(*MCInstrInfoCtorFnTy)() __attribute__((cdecl))*/
//  public final class MCInstrInfoCtorFnTy extends MCInstrInfo * (/*P*/ )()/* __attribute__((cdecl))*/{ };
  /*typedef MCInstrAnalysis *(*MCInstrAnalysisCtorFnTy)(const MCInstrInfo *) __attribute__((cdecl))*/
//  public final class MCInstrAnalysisCtorFnTy extends MCInstrAnalysis * (/*P*/ )(/*const*/MCInstrInfo /*P*/ )/* __attribute__((cdecl))*/{ };
  /*typedef MCRegisterInfo *(*MCRegInfoCtorFnTy)(StringRef) __attribute__((cdecl))*/
//  public final class MCRegInfoCtorFnTy extends MCRegisterInfo * (/*P*/ )(StringRef)/* __attribute__((cdecl))*/{ };
  /*typedef MCSubtargetInfo *(*MCSubtargetInfoCtorFnTy)(StringRef, StringRef, StringRef) __attribute__((cdecl))*/
//  public final class MCSubtargetInfoCtorFnTy extends MCSubtargetInfo * (/*P*/ )(StringRef, StringRef, StringRef)/* __attribute__((cdecl))*/{ };
  /*typedef TargetMachine *(*TargetMachineCtorTy)(const Target &, StringRef, StringRef, StringRef, const TargetOptions &, Reloc::Model, CodeModel::Model, CodeGenOpt::Level) __attribute__((cdecl))*/
//  public final class TargetMachineCtorTy extends TargetMachine * (/*P*/ )(/*const*/Target /*&*/ , StringRef, StringRef, StringRef, /*const*/TargetOptions /*&*/ , Reloc.Model, CodeModel.Model, CodeGenOpt.Level)/* __attribute__((cdecl))*/{ };
  /*typedef AsmPrinter *(*AsmPrinterCtorTy)(TargetMachine &, MCStreamer &) __attribute__((cdecl))*/
//  public final class AsmPrinterCtorTy extends AsmPrinter * (/*P*/ )(TargetMachine /*&*/ , MCStreamer /*&*/ )/* __attribute__((cdecl))*/{ };
  /*typedef MCAsmBackend *(*MCAsmBackendCtorTy)(const Target &, const MCRegisterInfo &, StringRef, StringRef) __attribute__((cdecl))*/
//  public final class MCAsmBackendCtorTy extends MCAsmBackend * (/*P*/ )(/*const*/Target /*&*/ , /*const*/MCRegisterInfo /*&*/ , StringRef, StringRef)/* __attribute__((cdecl))*/{ };
  /*typedef MCTargetAsmParser *(*MCAsmParserCtorTy)(MCSubtargetInfo &, MCAsmParser &, const MCInstrInfo &) __attribute__((cdecl))*/
//  public final class MCAsmParserCtorTy extends MCTargetAsmParser * (/*P*/ )(MCSubtargetInfo /*&*/ , MCAsmParser /*&*/ , /*const*/MCInstrInfo /*&*/ )/* __attribute__((cdecl))*/{ };
  /*typedef MCDisassembler *(*MCDisassemblerCtorTy)(const Target &, const MCSubtargetInfo &) __attribute__((cdecl))*/
//  public final class MCDisassemblerCtorTy extends MCDisassembler * (/*P*/ )(/*const*/Target /*&*/ , /*const*/MCSubtargetInfo /*&*/ )/* __attribute__((cdecl))*/{ };
  /*typedef MCInstPrinter *(*MCInstPrinterCtorTy)(const Target &, unsigned int, const MCAsmInfo &, const MCInstrInfo &, const MCRegisterInfo &, const MCSubtargetInfo &) __attribute__((cdecl))*/
//  public final class MCInstPrinterCtorTy extends MCInstPrinter * (/*P*/ )(/*const*/Target /*&*/ , /*uint*/int, /*const*/MCAsmInfo /*&*/ , /*const*/MCInstrInfo /*&*/ , /*const*/MCRegisterInfo /*&*/ , /*const*/MCSubtargetInfo /*&*/ )/* __attribute__((cdecl))*/{ };
  /*typedef MCCodeEmitter *(*MCCodeEmitterCtorTy)(const MCInstrInfo &, const MCRegisterInfo &, const MCSubtargetInfo &, MCContext &) __attribute__((cdecl))*/
//  public final class MCCodeEmitterCtorTy extends MCCodeEmitter * (/*P*/ )(/*const*/MCInstrInfo /*&*/ , /*const*/MCRegisterInfo /*&*/ , /*const*/MCSubtargetInfo /*&*/ , MCContext /*&*/ )/* __attribute__((cdecl))*/{ };
  /*typedef MCStreamer *(*MCObjectStreamerCtorTy)(const Target &, StringRef, MCContext &, MCAsmBackend &, raw_ostream &, MCCodeEmitter *, bool, bool) __attribute__((cdecl))*/
//  public final class MCObjectStreamerCtorTy extends MCStreamer * (/*P*/ )(/*const*/Target /*&*/ , StringRef, MCContext /*&*/ , MCAsmBackend /*&*/ , raw_ostream /*&*/ , MCCodeEmitter /*P*/ , boolean, boolean)/* __attribute__((cdecl))*/{ };
  /*typedef MCStreamer *(*AsmStreamerCtorTy)(MCContext &, formatted_raw_ostream &, bool, bool, bool, bool, MCInstPrinter *, MCCodeEmitter *, MCAsmBackend *, bool) __attribute__((cdecl))*/
//  public final class AsmStreamerCtorTy extends MCStreamer * (/*P*/ )(MCContext /*&*/ , formatted_raw_ostream /*&*/ , boolean, boolean, boolean, boolean, MCInstPrinter /*P*/ , MCCodeEmitter /*P*/ , MCAsmBackend /*P*/ , boolean)/* __attribute__((cdecl))*/{ };
  /*typedef MCRelocationInfo *(*MCRelocationInfoCtorTy)(StringRef, MCContext &) __attribute__((cdecl))*/
//  public final class MCRelocationInfoCtorTy extends MCRelocationInfo * (/*P*/ )(StringRef, MCContext /*&*/ )/* __attribute__((cdecl))*/{ };
  /*typedef MCSymbolizer *(*MCSymbolizerCtorTy)(StringRef, LLVMOpInfoCallback, LLVMSymbolLookupCallback, void *, MCContext *, MCRelocationInfo *) __attribute__((cdecl))*/
//  public final class MCSymbolizerCtorTy extends MCSymbolizer * (/*P*/ )(StringRef, LLVMOpInfoCallback, LLVMSymbolLookupCallback, void$ptr/*void P*/ , MCContext /*P*/ , MCRelocationInfo /*P*/ )/* __attribute__((cdecl))*/{ };
/*private:*/
  /// Next - The next registered target in the linked list, maintained by the
  /// TargetRegistry.
  /*friend*/public Target /*P*/ Next;
  
  /// The target function for checking if an architecture is supported.
  /*friend*/public ArchMatchFnTy ArchMatchFn;

  /// TripleMatchQualityFn - The target function for rating the match quality
  /// of a triple.
  /*friend*/public TripleMatchQualityFnTy TripleMatchQualityFn;
  
  /// Name - The target name.
  /*friend*/public /*const*/char$ptr/*char P*/ Name;
  
  /// ShortDesc - A short description of the target.
  /*friend*/public /*const*/char$ptr/*char P*/ ShortDesc;
  
  /// HasJIT - Whether this target supports the JIT.
  /*friend*/public boolean HasJIT;
  
  
  /*friend*/public/*private*/ MCAdjustCodeGenOptsFnTy MCAdjustCodeGenOptsFn;
          
  /// MCAsmInfoCtorFn - Constructor function for this target's MCAsmInfo, if
  /// registered.
  /*friend*/public MCAsmInfoCtorFnTy MCAsmInfoCtorFn;
  
  /// MCCodeGenInfoCtorFn - Constructor function for this target's
  /// MCCodeGenInfo, if registered.
  /*friend*/public MCCodeGenInfoCtorFnTy MCCodeGenInfoCtorFn;
  
  /// MCInstrInfoCtorFn - Constructor function for this target's MCInstrInfo,
  /// if registered.
  /*friend*/public MCInstrInfoCtorFnTy MCInstrInfoCtorFn;
  
  /// MCInstrAnalysisCtorFn - Constructor function for this target's
  /// MCInstrAnalysis, if registered.
  /*friend*/public MCInstrAnalysisCtorFnTy MCInstrAnalysisCtorFn;
  
  /// MCRegInfoCtorFn - Constructor function for this target's MCRegisterInfo,
  /// if registered.
  /*friend*/public MCRegInfoCtorFnTy MCRegInfoCtorFn;
  
  /// MCSubtargetInfoCtorFn - Constructor function for this target's
  /// MCSubtargetInfo, if registered.
  /*friend*/public MCSubtargetInfoCtorFnTy MCSubtargetInfoCtorFn;
  
  /// TargetMachineCtorFn - Construction function for this target's
  /// TargetMachine, if registered.
  /*friend*/public TargetMachineCtorTy TargetMachineCtorFn;
  
  /// MCAsmBackendCtorFn - Construction function for this target's
  /// MCAsmBackend, if registered.
  /*friend*/public MCAsmBackendCtorTy MCAsmBackendCtorFn;
  
  /// MCAsmParserCtorFn - Construction function for this target's
  /// MCTargetAsmParser, if registered.
  /*friend*/public MCAsmParserCtorTy MCAsmParserCtorFn;
  
  /// AsmPrinterCtorFn - Construction function for this target's AsmPrinter,
  /// if registered.
  /*friend*/public AsmPrinterCtorTy AsmPrinterCtorFn;
  
  /// MCDisassemblerCtorFn - Construction function for this target's
  /// MCDisassembler, if registered.
  /*friend*/public MCDisassemblerCtorTy MCDisassemblerCtorFn;
  
  /// MCInstPrinterCtorFn - Construction function for this target's
  /// MCInstPrinter, if registered.
  /*friend*/public MCInstPrinterCtorTy MCInstPrinterCtorFn;
  
  /// MCCodeEmitterCtorFn - Construction function for this target's
  /// CodeEmitter, if registered.
  /*friend*/public MCCodeEmitterCtorTy MCCodeEmitterCtorFn;
  
  /// MCObjectStreamerCtorFn - Construction function for this target's
  /// MCObjectStreamer, if registered.
  /*friend*/public MCObjectStreamerCtorTy MCObjectStreamerCtorFn;
  
  /// AsmStreamerCtorFn - Construction function for this target's
  /// AsmStreamer, if registered (default = llvm::createAsmStreamer).
  /*friend*/public AsmStreamerCtorTy AsmStreamerCtorFn;
  
  /// MCRelocationInfoCtorFn - Construction function for this target's
  /// MCRelocationInfo, if registered (default = llvm::createMCRelocationInfo)
  /*friend*/public MCRelocationInfoCtorTy MCRelocationInfoCtorFn;
  
  /// MCSymbolizerCtorFn - Construction function for this target's
  /// MCSymbolizer, if registered (default = llvm::createMCSymbolizer)
  /*friend*/public MCSymbolizerCtorTy MCSymbolizerCtorFn;
  
  /*friend*/public COFFStreamerCtorTy COFFStreamerCtorFn;
  /*friend*/public MachOStreamerCtorTy MachOStreamerCtorFn;
  /*friend*/public ELFStreamerCtorTy ELFStreamerCtorFn;
  /*friend*/public NullTargetStreamerCtorTy NullTargetStreamerCtorFn;
  /*friend*/public AsmTargetStreamerCtorTy AsmTargetStreamerCtorFn;
  /*friend*/public ObjectTargetStreamerCtorTy ObjectTargetStreamerCtorFn;
  
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Target::Target">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 254,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", old_line = 238,
   FQN = "llvm::Target::Target", NM = "_ZN4llvm6TargetC1Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZN4llvm6TargetC1Ev")
  //</editor-fold>
  public Target() {
    /* : AsmStreamerCtorFn(0), MCRelocationInfoCtorFn(0), MCSymbolizerCtorFn(0)*/ 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// @name Target Information
  /// @{
  
  // getNext - Return the next registered target.
  //<editor-fold defaultstate="collapsed" desc="llvm::Target::getNext">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 264,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", old_line = 246,
   FQN = "llvm::Target::getNext", NM = "_ZNK4llvm6Target7getNextEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZNK4llvm6Target7getNextEv")
  //</editor-fold>
  public /*const*/Target /*P*/ getNext() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// getName - Get the target name.
  //<editor-fold defaultstate="collapsed" desc="llvm::Target::getName">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 267,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", old_line = 249,
   FQN = "llvm::Target::getName", NM = "_ZNK4llvm6Target7getNameEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZNK4llvm6Target7getNameEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getName() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// getShortDescription - Get a short description of the target.
  //<editor-fold defaultstate="collapsed" desc="llvm::Target::getShortDescription">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 270,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", old_line = 252,
   FQN = "llvm::Target::getShortDescription", NM = "_ZNK4llvm6Target19getShortDescriptionEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZNK4llvm6Target19getShortDescriptionEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getShortDescription() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// @}
  /// @name Feature Predicates
  /// @{
  
  /// hasJIT - Check if this targets supports the just-in-time compilation.
  //<editor-fold defaultstate="collapsed" desc="llvm::Target::hasJIT">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 277,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", old_line = 259,
   FQN = "llvm::Target::hasJIT", NM = "_ZNK4llvm6Target6hasJITEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZNK4llvm6Target6hasJITEv")
  //</editor-fold>
  public boolean hasJIT() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// hasTargetMachine - Check if this target supports code generation.
  //<editor-fold defaultstate="collapsed" desc="llvm::Target::hasTargetMachine">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 280,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", old_line = 262,
   FQN = "llvm::Target::hasTargetMachine", NM = "_ZNK4llvm6Target16hasTargetMachineEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZNK4llvm6Target16hasTargetMachineEv")
  //</editor-fold>
  public boolean hasTargetMachine() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// hasMCAsmBackend - Check if this target supports .o generation.
  //<editor-fold defaultstate="collapsed" desc="llvm::Target::hasMCAsmBackend">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 283,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", old_line = 265,
   FQN = "llvm::Target::hasMCAsmBackend", NM = "_ZNK4llvm6Target15hasMCAsmBackendEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZNK4llvm6Target15hasMCAsmBackendEv")
  //</editor-fold>
  public boolean hasMCAsmBackend() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// @}
  /// @name Feature Constructors
  /// @{
  
  /// createMCAsmInfo - Create a MCAsmInfo implementation for the specified
  /// target triple.
  ///
  /// \param Triple This argument is used to determine the target machine
  /// feature set; it should always be provided. Generally this should be
  /// either the target triple from the module, or the target triple of the
  /// host if that does not exist.
  //<editor-fold defaultstate="collapsed" desc="llvm::Target::createMCAsmInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 296,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", old_line = 278,
   FQN = "llvm::Target::createMCAsmInfo", NM = "_ZNK4llvm6Target15createMCAsmInfoERKNS_14MCRegisterInfoENS_9StringRefE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZNK4llvm6Target15createMCAsmInfoERKNS_14MCRegisterInfoENS_9StringRefE")
  //</editor-fold>
  public MCAsmInfo /*P*/ createMCAsmInfo(/*const*/MCRegisterInfo /*&*/ MRI, StringRef Triple) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// createMCCodeGenInfo - Create a MCCodeGenInfo implementation.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::Target::createMCCodeGenInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 305,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", old_line = 287,
   FQN = "llvm::Target::createMCCodeGenInfo", NM = "_ZNK4llvm6Target19createMCCodeGenInfoENS_9StringRefENS_5Reloc5ModelENS_9CodeModel5ModelENS_10CodeGenOpt5LevelE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZNK4llvm6Target19createMCCodeGenInfoENS_9StringRefENS_5Reloc5ModelENS_9CodeModel5ModelENS_10CodeGenOpt5LevelE")
  //</editor-fold>
  public MCCodeGenInfo /*P*/ createMCCodeGenInfo(StringRef Triple, Reloc.Model RM, CodeModel.Model CM, CodeGenOpt.Level OL) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// createMCInstrInfo - Create a MCInstrInfo implementation.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::Target::createMCInstrInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 315,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", old_line = 297,
   FQN = "llvm::Target::createMCInstrInfo", NM = "_ZNK4llvm6Target17createMCInstrInfoEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZNK4llvm6Target17createMCInstrInfoEv")
  //</editor-fold>
  public MCInstrInfo /*P*/ createMCInstrInfo() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// createMCInstrAnalysis - Create a MCInstrAnalysis implementation.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::Target::createMCInstrAnalysis">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 323,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", old_line = 305,
   FQN = "llvm::Target::createMCInstrAnalysis", NM = "_ZNK4llvm6Target21createMCInstrAnalysisEPKNS_11MCInstrInfoE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZNK4llvm6Target21createMCInstrAnalysisEPKNS_11MCInstrInfoE")
  //</editor-fold>
  public MCInstrAnalysis /*P*/ createMCInstrAnalysis(/*const*/MCInstrInfo /*P*/ Info) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// createMCRegInfo - Create a MCRegisterInfo implementation.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::Target::createMCRegInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 331,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", old_line = 313,
   FQN = "llvm::Target::createMCRegInfo", NM = "_ZNK4llvm6Target15createMCRegInfoENS_9StringRefE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZNK4llvm6Target15createMCRegInfoENS_9StringRefE")
  //</editor-fold>
  public MCRegisterInfo /*P*/ createMCRegInfo(StringRef Triple) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// createMCSubtargetInfo - Create a MCSubtargetInfo implementation.
  ///
  /// \param Triple This argument is used to determine the target machine
  /// feature set; it should always be provided. Generally this should be
  /// either the target triple from the module, or the target triple of the
  /// host if that does not exist.
  /// \param CPU This specifies the name of the target CPU.
  /// \param Features This specifies the string representation of the
  /// additional target features.
  //<editor-fold defaultstate="collapsed" desc="llvm::Target::createMCSubtargetInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 346,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", old_line = 328,
   FQN = "llvm::Target::createMCSubtargetInfo", NM = "_ZNK4llvm6Target21createMCSubtargetInfoENS_9StringRefES1_S1_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZNK4llvm6Target21createMCSubtargetInfoENS_9StringRefES1_S1_")
  //</editor-fold>
  public MCSubtargetInfo /*P*/ createMCSubtargetInfo(StringRef Triple, StringRef CPU, StringRef Features) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

//  
//  /// createTargetMachine - Create a target specific machine implementation
//  /// for the specified \p Triple.
//  ///
//  /// \param Triple This argument is used to determine the target machine
//  /// feature set; it should always be provided. Generally this should be
//  /// either the target triple from the module, or the target triple of the
//  /// host if that does not exist.
//  //<editor-fold defaultstate="collapsed" desc="llvm::Target::createTargetMachine">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 343,
//   cmd="jclank.sh ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -filter=llvm::Target::createTargetMachine")
//  //</editor-fold>
//  public TargetMachine /*P*/ createTargetMachine(StringRef Triple, StringRef CPU, StringRef Features, /*const*/TargetOptions /*&*/ Options) /*const*/ {
//    return createTargetMachine(Triple, CPU, Features, Options, Reloc.Model.Default, CodeModel.Model.Default, CodeGenOpt.Level.Default);
//  }
//  public TargetMachine /*P*/ createTargetMachine(StringRef Triple, StringRef CPU, StringRef Features, /*const*/TargetOptions /*&*/ Options, Reloc.Model RM/*= Reloc::Default*/) /*const*/ {
//    return createTargetMachine(Triple, CPU, Features, Options, RM, CodeModel.Model.Default, CodeGenOpt.Level.Default);
//  }
//  public TargetMachine /*P*/ createTargetMachine(StringRef Triple, StringRef CPU, StringRef Features, /*const*/TargetOptions /*&*/ Options, Reloc.Model RM/*= Reloc::Default*/, CodeModel.Model CM/*= CodeModel::Default*/) /*const*/ {
//    return createTargetMachine(Triple, CPU, Features, Options, RM, CM, CodeGenOpt.Level.Default);
//  }
//  public TargetMachine /*P*/ createTargetMachine(StringRef Triple, StringRef CPU, StringRef Features, /*const*/TargetOptions /*&*/ Options, Reloc.Model RM/*= Reloc::Default*/, CodeModel.Model CM/*= CodeModel::Default*/, CodeGenOpt.Level OL/*= CodeGenOpt::Default*/) /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
  @Converted(kind = Converted.Kind.DUMMY)
  public Object/*TargetMachine*/ /*P*/ createTargetMachine(StringRef Triple, StringRef CPU, StringRef Features, /*const*//*TargetOptions*/Object /*&*/ Options, Reloc.Model RM/*= Reloc::Default*/, CodeModel.Model CM/*= CodeModel::Default*/, CodeGenOpt.Level OL/*= CodeGenOpt::Default*/) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  /// createMCAsmBackend - Create a target specific assembly parser.
  ///
  /// \param Triple The target triple string.
  //<editor-fold defaultstate="collapsed" desc="llvm::Target::createMCAsmBackend">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 375,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", old_line = 356,
   FQN = "llvm::Target::createMCAsmBackend", NM = "_ZNK4llvm6Target18createMCAsmBackendERKNS_14MCRegisterInfoENS_9StringRefES4_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZNK4llvm6Target18createMCAsmBackendERKNS_14MCRegisterInfoENS_9StringRefES4_")
  //</editor-fold>
  public MCAsmBackend /*P*/ createMCAsmBackend(/*const*/MCRegisterInfo /*&*/ MRI, StringRef Triple, StringRef CPU) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// createMCAsmParser - Create a target specific assembly parser.
  ///
  /// \param Parser The target independent parser implementation to use for
  /// parsing and lexing.
  //<editor-fold defaultstate="collapsed" desc="llvm::Target::createMCAsmParser">
  @Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 367,
   FQN = "llvm::Target::createMCAsmParser", NM = "_ZNK4llvm6Target17createMCAsmParserERNS_15MCSubtargetInfoERNS_11MCAsmParserERKNS_11MCInstrInfoERKNS_15MCTargetOptionsE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZNK4llvm6Target17createMCAsmParserERNS_15MCSubtargetInfoERNS_11MCAsmParserERKNS_11MCInstrInfoERKNS_15MCTargetOptionsE")
  //</editor-fold>
  public MCTargetAsmParser /*P*/ createMCAsmParser(MCSubtargetInfo /*&*/ STI, 
                   MCAsmParser /*&*/ Parser, 
                   /*const*/ MCInstrInfo /*&*/ MII, 
                   /*const*/ MCTargetOptions /*&*/ Options) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
//  /// createAsmPrinter - Create a target specific assembly printer pass.  This
//  /// takes ownership of the MCStreamer object.
//  //<editor-fold defaultstate="collapsed" desc="llvm::Target::createAsmPrinter">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 378,
//   cmd="jclank.sh ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -filter=llvm::Target::createAsmPrinter")
//  //</editor-fold>
//  public AsmPrinter /*P*/ createAsmPrinter(TargetMachine /*&*/ TM, MCStreamer /*&*/ Streamer) /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Target::createMCDisassembler">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 404,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", old_line = 385,
   FQN = "llvm::Target::createMCDisassembler", NM = "_ZNK4llvm6Target20createMCDisassemblerERKNS_15MCSubtargetInfoERNS_9MCContextE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZNK4llvm6Target20createMCDisassemblerERKNS_15MCSubtargetInfoERNS_9MCContextE")
  //</editor-fold>
  public MCDisassembler /*P*/ createMCDisassembler(/*const*/ MCSubtargetInfo /*&*/ STI, 
                      MCContext /*&*/ Ctx) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Target::createMCInstPrinter">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 411,
   FQN="llvm::Target::createMCInstPrinter", NM="_ZNK4llvm6Target19createMCInstPrinterERKNS_6TripleEjRKNS_9MCAsmInfoERKNS_11MCInstrInfoERKNS_14MCRegisterInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZNK4llvm6Target19createMCInstPrinterERKNS_6TripleEjRKNS_9MCAsmInfoERKNS_11MCInstrInfoERKNS_14MCRegisterInfoE")
  //</editor-fold>
  public MCInstPrinter /*P*/ createMCInstPrinter(/*const*/ Triple /*&*/ T, /*uint*/int SyntaxVariant, 
                     /*const*/ MCAsmInfo /*&*/ MAI, 
                     /*const*/ MCInstrInfo /*&*/ MII, 
                     /*const*/ MCRegisterInfo /*&*/ MRI) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// createMCCodeEmitter - Create a target specific code emitter.
  //<editor-fold defaultstate="collapsed" desc="llvm::Target::createMCCodeEmitter">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 421,
   FQN="llvm::Target::createMCCodeEmitter", NM="_ZNK4llvm6Target19createMCCodeEmitterERKNS_11MCInstrInfoERKNS_14MCRegisterInfoERNS_9MCContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZNK4llvm6Target19createMCCodeEmitterERKNS_11MCInstrInfoERKNS_14MCRegisterInfoERNS_9MCContextE")
  //</editor-fold>
  public MCCodeEmitter /*P*/ createMCCodeEmitter(/*const*/ MCInstrInfo /*&*/ II, 
                     /*const*/ MCRegisterInfo /*&*/ MRI, 
                     MCContext /*&*/ Ctx) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Create a target specific MCStreamer.
  ///
  /// \param T The target triple.
  /// \param Ctx The target context.
  /// \param TAB The target assembler backend object. Takes ownership.
  /// \param OS The stream object.
  /// \param Emitter The target independent assembler object.Takes ownership.
  /// \param RelaxAll Relax all fixups?
  //<editor-fold defaultstate="collapsed" desc="llvm::Target::createMCObjectStreamer">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 437,
   FQN="llvm::Target::createMCObjectStreamer", NM="_ZNK4llvm6Target22createMCObjectStreamerERKNS_6TripleERNS_9MCContextERNS_12MCAsmBackendERNS_17raw_pwrite_streamEPNS_13MCCodeEmitterERKNS_15MCSubtargetInfoEbbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZNK4llvm6Target22createMCObjectStreamerERKNS_6TripleERNS_9MCContextERNS_12MCAsmBackendERNS_17raw_pwrite_streamEPNS_13MCCodeEmitterERKNS_15MCSubtargetInfoEbbb")
  //</editor-fold>
  public MCStreamer /*P*/ createMCObjectStreamer(/*const*/ Triple /*&*/ T, MCContext /*&*/ Ctx, 
                        MCAsmBackend /*&*/ TAB, raw_pwrite_stream /*&*/ OS, 
                        MCCodeEmitter /*P*/ Emitter, 
                        /*const*/ MCSubtargetInfo /*&*/ STI, boolean RelaxAll, 
                        boolean IncrementalLinkerCompatible, 
                        boolean DWARFMustBeAtTheEnd) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Target::createAsmStreamer">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 472,
   FQN="llvm::Target::createAsmStreamer", NM="_ZNK4llvm6Target17createAsmStreamerERNS_9MCContextESt10unique_ptrINS_21formatted_raw_ostreamESt14default_deleteIS4_EEbbPNS_13MCInstPrinterEPNS_13MCCodeEmitterEPNS_12MCAsmBackendEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZNK4llvm6Target17createAsmStreamerERNS_9MCContextESt10unique_ptrINS_21formatted_raw_ostreamESt14default_deleteIS4_EEbbPNS_13MCInstPrinterEPNS_13MCCodeEmitterEPNS_12MCAsmBackendEb")
  //</editor-fold>
  public MCStreamer /*P*/ createAsmStreamer(MCContext /*&*/ Ctx, 
                   std.unique_ptr<formatted_raw_ostream> OS, 
                   boolean IsVerboseAsm, boolean UseDwarfDirectory, 
                   MCInstPrinter /*P*/ InstPrint, MCCodeEmitter /*P*/ CE, 
                   MCAsmBackend /*P*/ TAB, boolean ShowInst) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// createMCRelocationInfo - Create a target specific MCRelocationInfo.
  ///
  /// \param TT The target triple.
  /// \param Ctx The target context.
  //<editor-fold defaultstate="collapsed" desc="llvm::Target::createMCRelocationInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 510,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", old_line = 458,
   FQN = "llvm::Target::createMCRelocationInfo", NM = "_ZNK4llvm6Target22createMCRelocationInfoENS_9StringRefERNS_9MCContextE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -nm=_ZNK4llvm6Target22createMCRelocationInfoENS_9StringRefERNS_9MCContextE")
  //</editor-fold>
  public MCRelocationInfo /*P*/ createMCRelocationInfo(StringRef TT, MCContext /*&*/ Ctx) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
//  /// createMCSymbolizer - Create a target specific MCSymbolizer.
//  ///
//  /// \param TT The target triple.
//  /// \param GetOpInfo The function to get the symbolic information for operands.
//  /// \param SymbolLookUp The function to lookup a symbol name.
//  /// \param DisInfo The pointer to the block of symbolic information for above call
//  /// back.
//  /// \param Ctx The target context.
//  /// \param RelInfo The relocation information for this target. Takes ownership.
//  //<editor-fold defaultstate="collapsed" desc="llvm::Target::createMCSymbolizer">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", line = 473,
//   cmd="jclank.sh ${LLVM_SRC}/llvm/lib/Support/TargetRegistry.cpp -filter=llvm::Target::createMCSymbolizer")
//  //</editor-fold>
//  public MCSymbolizer /*P*/ createMCSymbolizer(StringRef TT, int (/*P*/ GetOpInfo)(void$ptr/*void P*/ , long/*uint64_t*/, long/*uint64_t*/, long/*uint64_t*/, int, void$ptr/*void P*/ )/* __attribute__((cdecl))*/, /*const*/char * (/*P*/ SymbolLookUp)(void$ptr/*void P*/ , long/*uint64_t*/, uint$ptr/*uint64_t P*/ , long/*uint64_t*/, /*const*/type$ptr<char$ptr>/*char PP*/ )/* __attribute__((cdecl))*/, void$ptr/*void P*/ DisInfo, MCContext /*P*/ Ctx, MCRelocationInfo /*P*/ RelInfo) /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }

/// @}
}
