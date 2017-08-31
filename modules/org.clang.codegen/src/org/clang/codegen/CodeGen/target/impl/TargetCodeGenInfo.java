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

package org.clang.codegen.CodeGen.target.impl;

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.impl.*;
import org.llvm.ir.Type;


/// TargetCodeGenInfo - This class organizes various target-specific
/// codegeneration issues, like target-specific attributes, builtins and so
/// on.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::TargetCodeGenInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.h", line = 44,
 FQN="clang::CodeGen::TargetCodeGenInfo", NM="_ZN5clang7CodeGen17TargetCodeGenInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN5clang7CodeGen17TargetCodeGenInfoE")
//</editor-fold>
public class TargetCodeGenInfo implements Destructors.ClassWithDestructor {
  private ABIInfo /*P*/ Info;
/*public:*/
  // WARNING: Acquires the ownership of ABIInfo.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::TargetCodeGenInfo::TargetCodeGenInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.h", line = 49,
   FQN="clang::CodeGen::TargetCodeGenInfo::TargetCodeGenInfo", NM="_ZN5clang7CodeGen17TargetCodeGenInfoC1EPNS0_7ABIInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN5clang7CodeGen17TargetCodeGenInfoC1EPNS0_7ABIInfoE")
  //</editor-fold>
  public TargetCodeGenInfo() {
    this((ABIInfo /*P*/ )null);
  }
  public TargetCodeGenInfo(ABIInfo /*P*/ info/*= null*/) {
    // : Info(info) 
    //START JInit
    this.Info = info;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::TargetCodeGenInfo::~TargetCodeGenInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 342,
   FQN="clang::CodeGen::TargetCodeGenInfo::~TargetCodeGenInfo", NM="_ZN5clang7CodeGen17TargetCodeGenInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN5clang7CodeGen17TargetCodeGenInfoD0Ev")
  //</editor-fold>
  public void $destroy() {
    /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)Info);
  }

  
  /// getABIInfo() - Returns ABI info helper for the target.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::TargetCodeGenInfo::getABIInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.h", line = 53,
   FQN="clang::CodeGen::TargetCodeGenInfo::getABIInfo", NM="_ZNK5clang7CodeGen17TargetCodeGenInfo10getABIInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen17TargetCodeGenInfo10getABIInfoEv")
  //</editor-fold>
  public /*const*/ ABIInfo /*&*/ getABIInfo() /*const*/ {
    return /*Deref*/Info;
  }

  
  /// setTargetAttributes - Provides a convenient hook to handle extra
  /// target-specific attributes for the given global.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::TargetCodeGenInfo::setTargetAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.h", line = 57,
   FQN="clang::CodeGen::TargetCodeGenInfo::setTargetAttributes", NM="_ZNK5clang7CodeGen17TargetCodeGenInfo19setTargetAttributesEPKNS_4DeclEPN4llvm11GlobalValueERNS0_13CodeGenModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen17TargetCodeGenInfo19setTargetAttributesEPKNS_4DeclEPN4llvm11GlobalValueERNS0_13CodeGenModuleE")
  //</editor-fold>
  public /*virtual*/ void setTargetAttributes(/*const*/ Decl /*P*/ D, GlobalValue /*P*/ GV, 
                     final CodeGenModule /*&*/ M) /*const*/ {
  }

  
  /// emitTargetMD - Provides a convenient hook to handle extra
  /// target-specific metadata for the given global.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::TargetCodeGenInfo::emitTargetMD">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.h", line = 62,
   FQN="clang::CodeGen::TargetCodeGenInfo::emitTargetMD", NM="_ZNK5clang7CodeGen17TargetCodeGenInfo12emitTargetMDEPKNS_4DeclEPN4llvm11GlobalValueERNS0_13CodeGenModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen17TargetCodeGenInfo12emitTargetMDEPKNS_4DeclEPN4llvm11GlobalValueERNS0_13CodeGenModuleE")
  //</editor-fold>
  public /*virtual*/ void emitTargetMD(/*const*/ Decl /*P*/ D, GlobalValue /*P*/ GV, 
              final CodeGenModule /*&*/ M) /*const*/ {
  }

  
  /// Determines the size of struct _Unwind_Exception on this platform,
  /// in 8-bit units.  The Itanium ABI defines this as:
  ///   struct _Unwind_Exception {
  ///     uint64 exception_class;
  ///     _Unwind_Exception_Cleanup_Fn exception_cleanup;
  ///     uint64 private_1;
  ///     uint64 private_2;
  ///   };
  
  // If someone can figure out a general rule for this, that would be great.
  // It's probably just doomed to be platform-dependent, though.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::TargetCodeGenInfo::getSizeOfUnwindException">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 346,
   FQN="clang::CodeGen::TargetCodeGenInfo::getSizeOfUnwindException", NM="_ZNK5clang7CodeGen17TargetCodeGenInfo24getSizeOfUnwindExceptionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen17TargetCodeGenInfo24getSizeOfUnwindExceptionEv")
  //</editor-fold>
  public /*uint*/int getSizeOfUnwindException() /*const*/ {
    // Verified for:
    //   x86-64     FreeBSD, Linux, Darwin
    //   x86-32     FreeBSD, Linux, Darwin
    //   PowerPC    Linux, Darwin
    //   ARM        Darwin (*not* EABI)
    //   AArch64    Linux
    return 32;
  }

  
  /// Controls whether __builtin_extend_pointer should sign-extend
  /// pointers to uint64_t or zero-extend them (the default).  Has
  /// no effect for targets:
  ///   - that have 64-bit pointers, or
  ///   - that cannot address through registers larger than pointers, or
  ///   - that implicitly ignore/truncate the top bits when addressing
  ///     through such registers.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::TargetCodeGenInfo::extendPointerWithSExt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.h", line = 82,
   FQN="clang::CodeGen::TargetCodeGenInfo::extendPointerWithSExt", NM="_ZNK5clang7CodeGen17TargetCodeGenInfo21extendPointerWithSExtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen17TargetCodeGenInfo21extendPointerWithSExtEv")
  //</editor-fold>
  public /*virtual*/ boolean extendPointerWithSExt() /*const*/ {
    return false;
  }

  
  /// Determines the DWARF register number for the stack pointer, for
  /// exception-handling purposes.  Implements __builtin_dwarf_sp_column.
  ///
  /// Returns -1 if the operation is unsupported by this target.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::TargetCodeGenInfo::getDwarfEHStackPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.h", line = 88,
   FQN="clang::CodeGen::TargetCodeGenInfo::getDwarfEHStackPointer", NM="_ZNK5clang7CodeGen17TargetCodeGenInfo22getDwarfEHStackPointerERNS0_13CodeGenModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen17TargetCodeGenInfo22getDwarfEHStackPointerERNS0_13CodeGenModuleE")
  //</editor-fold>
  public /*virtual*/ int getDwarfEHStackPointer(final CodeGenModule /*&*/ M) /*const*/ {
    return -1;
  }

  
  /// Initializes the given DWARF EH register-size table, a char*.
  /// Implements __builtin_init_dwarf_reg_size_table.
  ///
  /// Returns true if the operation is unsupported by this target.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::TargetCodeGenInfo::initDwarfEHRegSizeTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.h", line = 96,
   FQN="clang::CodeGen::TargetCodeGenInfo::initDwarfEHRegSizeTable", NM="_ZNK5clang7CodeGen17TargetCodeGenInfo23initDwarfEHRegSizeTableERNS0_15CodeGenFunctionEPN4llvm5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen17TargetCodeGenInfo23initDwarfEHRegSizeTableERNS0_15CodeGenFunctionEPN4llvm5ValueE")
  //</editor-fold>
  public /*virtual*/ boolean initDwarfEHRegSizeTable(final CodeGenFunction /*&*/ CGF, 
                         Value /*P*/ Address) /*const*/ {
    return true;
  }

  
  /// Performs the code-generation required to convert a return
  /// address as stored by the system into the actual address of the
  /// next instruction that will be executed.
  ///
  /// Used by __builtin_extract_return_addr().
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::TargetCodeGenInfo::decodeReturnAddress">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.h", line = 106,
   FQN="clang::CodeGen::TargetCodeGenInfo::decodeReturnAddress", NM="_ZNK5clang7CodeGen17TargetCodeGenInfo19decodeReturnAddressERNS0_15CodeGenFunctionEPN4llvm5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen17TargetCodeGenInfo19decodeReturnAddressERNS0_15CodeGenFunctionEPN4llvm5ValueE")
  //</editor-fold>
  public /*virtual*/ Value /*P*/ decodeReturnAddress(final CodeGenFunction /*&*/ CGF, 
                     Value /*P*/ Address) /*const*/ {
    return Address;
  }

  
  /// Performs the code-generation required to convert the address
  /// of an instruction into a return address suitable for storage
  /// by the system in a return slot.
  ///
  /// Used by __builtin_frob_return_addr().
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::TargetCodeGenInfo::encodeReturnAddress">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.h", line = 116,
   FQN="clang::CodeGen::TargetCodeGenInfo::encodeReturnAddress", NM="_ZNK5clang7CodeGen17TargetCodeGenInfo19encodeReturnAddressERNS0_15CodeGenFunctionEPN4llvm5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen17TargetCodeGenInfo19encodeReturnAddressERNS0_15CodeGenFunctionEPN4llvm5ValueE")
  //</editor-fold>
  public /*virtual*/ Value /*P*/ encodeReturnAddress(final CodeGenFunction /*&*/ CGF, 
                     Value /*P*/ Address) /*const*/ {
    return Address;
  }

  
  /// Corrects the low-level LLVM type for a given constraint and "usual"
  /// type.
  ///
  /// \returns A pointer to a new LLVM type, possibly the same as the original
  /// on success; 0 on failure.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::TargetCodeGenInfo::adjustInlineAsmType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.h", line = 126,
   FQN="clang::CodeGen::TargetCodeGenInfo::adjustInlineAsmType", NM="_ZNK5clang7CodeGen17TargetCodeGenInfo19adjustInlineAsmTypeERNS0_15CodeGenFunctionEN4llvm9StringRefEPNS4_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen17TargetCodeGenInfo19adjustInlineAsmTypeERNS0_15CodeGenFunctionEN4llvm9StringRefEPNS4_4TypeE")
  //</editor-fold>
  public /*virtual*/ org.llvm.ir.Type /*P*/ adjustInlineAsmType(final CodeGenFunction /*&*/ CGF, 
                     StringRef Constraint, 
                     org.llvm.ir.Type /*P*/ Ty) /*const*/ {
    return Ty;
  }

  
  /// Adds constraints and types for result registers.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::TargetCodeGenInfo::addReturnRegisterOutputs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.h", line = 133,
   FQN="clang::CodeGen::TargetCodeGenInfo::addReturnRegisterOutputs", NM="_ZNK5clang7CodeGen17TargetCodeGenInfo24addReturnRegisterOutputsERNS0_15CodeGenFunctionENS0_6LValueERSsRSt6vectorIPN4llvm4TypeESaIS9_EESC_RS6_IS4_SaIS4_EES5_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen17TargetCodeGenInfo24addReturnRegisterOutputsERNS0_15CodeGenFunctionENS0_6LValueERSsRSt6vectorIPN4llvm4TypeESaIS9_EESC_RS6_IS4_SaIS4_EES5_j")
  //</editor-fold>
  public /*virtual*/ void addReturnRegisterOutputs(final CodeGenFunction /*&*/ CGF, LValue ReturnValue, 
                          final std.string/*&*/ Constraints, final std.vector<Type /*P*/ > /*&*/ ResultRegTypes, 
                          final std.vector<Type /*P*/ > /*&*/ ResultTruncRegTypes, 
                          final std.vector<LValue> /*&*/ ResultRegDests, final std.string/*&*/ AsmString, 
                          /*uint*/int NumOutputs) /*const*/ {
  }

  
  /// doesReturnSlotInterfereWithArgs - Return true if the target uses an
  /// argument slot for an 'sret' type.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::TargetCodeGenInfo::doesReturnSlotInterfereWithArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.h", line = 142,
   FQN="clang::CodeGen::TargetCodeGenInfo::doesReturnSlotInterfereWithArgs", NM="_ZNK5clang7CodeGen17TargetCodeGenInfo31doesReturnSlotInterfereWithArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen17TargetCodeGenInfo31doesReturnSlotInterfereWithArgsEv")
  //</editor-fold>
  public /*virtual*/ boolean doesReturnSlotInterfereWithArgs() /*const*/ {
    return true;
  }

  
  /// Retrieve the address of a function to call immediately before
  /// calling objc_retainAutoreleasedReturnValue.  The
  /// implementation of objc_autoreleaseReturnValue sniffs the
  /// instruction stream following its return address to decide
  /// whether it's a call to objc_retainAutoreleasedReturnValue.
  /// This can be prohibitively expensive, depending on the
  /// relocation model, and so on some targets it instead sniffs for
  /// a particular instruction sequence.  This functions returns
  /// that instruction sequence in inline assembly, which will be
  /// empty if none is required.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::TargetCodeGenInfo::getARCRetainAutoreleasedReturnValueMarker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.h", line = 154,
   FQN="clang::CodeGen::TargetCodeGenInfo::getARCRetainAutoreleasedReturnValueMarker", NM="_ZNK5clang7CodeGen17TargetCodeGenInfo41getARCRetainAutoreleasedReturnValueMarkerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen17TargetCodeGenInfo41getARCRetainAutoreleasedReturnValueMarkerEv")
  //</editor-fold>
  public /*virtual*/ StringRef getARCRetainAutoreleasedReturnValueMarker() /*const*/ {
    return new StringRef(/*KEEP_STR*/$EMPTY);
  }

  
  /// Return a constant used by UBSan as a signature to identify functions
  /// possessing type information, or 0 if the platform is unsupported.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::TargetCodeGenInfo::getUBSanFunctionSignature">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.h", line = 160,
   FQN="clang::CodeGen::TargetCodeGenInfo::getUBSanFunctionSignature", NM="_ZNK5clang7CodeGen17TargetCodeGenInfo25getUBSanFunctionSignatureERNS0_13CodeGenModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen17TargetCodeGenInfo25getUBSanFunctionSignatureERNS0_13CodeGenModuleE")
  //</editor-fold>
  public /*virtual*/ Constant /*P*/ getUBSanFunctionSignature(final CodeGenModule /*&*/ CGM) /*const*/ {
    return null;
  }

  
  /// Determine whether a call to an unprototyped functions under
  /// the given calling convention should use the variadic
  /// convention or the non-variadic convention.
  ///
  /// There's a good reason to make a platform's variadic calling
  /// convention be different from its non-variadic calling
  /// convention: the non-variadic arguments can be passed in
  /// registers (better for performance), and the variadic arguments
  /// can be passed on the stack (also better for performance).  If
  /// this is done, however, unprototyped functions *must* use the
  /// non-variadic convention, because C99 states that a call
  /// through an unprototyped function type must succeed if the
  /// function was defined with a non-variadic prototype with
  /// compatible parameters.  Therefore, splitting the conventions
  /// makes it impossible to call a variadic function through an
  /// unprototyped type.  Since function prototypes came out in the
  /// late 1970s, this is probably an acceptable trade-off.
  /// Nonetheless, not all platforms are willing to make it, and in
  /// particularly x86-64 bends over backwards to make the
  /// conventions compatible.
  ///
  /// The default is false.  This is correct whenever:
  ///   - the conventions are exactly the same, because it does not
  ///     matter and the resulting IR will be somewhat prettier in
  ///     certain cases; or
  ///   - the conventions are substantively different in how they pass
  ///     arguments, because in this case using the variadic convention
  ///     will lead to C99 violations.
  ///
  /// However, some platforms make the conventions identical except
  /// for passing additional out-of-band information to a variadic
  /// function: for example, x86-64 passes the number of SSE
  /// arguments in %al.  On these platforms, it is desirable to
  /// call unprototyped functions using the variadic convention so
  /// that unprototyped calls to varargs functions still succeed.
  ///
  /// Relatedly, platforms which pass the fixed arguments to this:
  ///   A foo(B, C, D);
  /// differently than they would pass them to this:
  ///   A foo(B, C, D, ...);
  /// may need to adjust the debugger-support code in Sema to do the
  /// right thing when calling a function with no know signature.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::TargetCodeGenInfo::isNoProtoCallVariadic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 356,
   FQN="clang::CodeGen::TargetCodeGenInfo::isNoProtoCallVariadic", NM="_ZNK5clang7CodeGen17TargetCodeGenInfo21isNoProtoCallVariadicERKNS0_11CallArgListEPKNS_19FunctionNoProtoTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen17TargetCodeGenInfo21isNoProtoCallVariadicERKNS0_11CallArgListEPKNS_19FunctionNoProtoTypeE")
  //</editor-fold>
  public boolean isNoProtoCallVariadic(final /*const*/ CallArgList /*&*/ args, 
                       /*const*/ FunctionNoProtoType /*P*/ fnType) /*const*/ {
    // The following conventions are known to require this to be false:
    //   x86_stdcall
    //   MIPS
    // For everything else, we just prefer false unless we opt out.
    return false;
  }

  
  /// Gets the linker options necessary to link a dependent library on this
  /// platform.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::TargetCodeGenInfo::getDependentLibraryOption">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 365,
   FQN="clang::CodeGen::TargetCodeGenInfo::getDependentLibraryOption", NM="_ZNK5clang7CodeGen17TargetCodeGenInfo25getDependentLibraryOptionEN4llvm9StringRefERNS2_11SmallStringILj24EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen17TargetCodeGenInfo25getDependentLibraryOptionEN4llvm9StringRefERNS2_11SmallStringILj24EEE")
  //</editor-fold>
  public void getDependentLibraryOption(StringRef Lib, 
                           final SmallString/*24*/ /*&*/ Opt) /*const*/ {
    // This assumes the user is passing a library name like "rt" instead of a
    // filename like "librt.a/so", and that they don't care whether it's static or
    // dynamic.
    Opt.$assign(/*STRINGREF_STR*/"-l");
    Opt.$addassign(/*NO_COPY*/Lib);
  }


  /// Gets the linker options necessary to detect object file mismatches on
  /// this platform.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::TargetCodeGenInfo::getDetectMismatchOption">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.h", line = 217,
   FQN="clang::CodeGen::TargetCodeGenInfo::getDetectMismatchOption", NM="_ZNK5clang7CodeGen17TargetCodeGenInfo23getDetectMismatchOptionEN4llvm9StringRefES3_RNS2_11SmallStringILj32EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen17TargetCodeGenInfo23getDetectMismatchOptionEN4llvm9StringRefES3_RNS2_11SmallStringILj32EEE")
  //</editor-fold>
  public /*virtual*/ void getDetectMismatchOption(StringRef Name, 
                         StringRef Value, 
                         final SmallString/*32*/ /*&*/ Opt) /*const*/ {
  }

  
  /// Get LLVM calling convention for OpenCL kernel.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::TargetCodeGenInfo::getOpenCLKernelCallingConv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 375,
   FQN="clang::CodeGen::TargetCodeGenInfo::getOpenCLKernelCallingConv", NM="_ZNK5clang7CodeGen17TargetCodeGenInfo26getOpenCLKernelCallingConvEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen17TargetCodeGenInfo26getOpenCLKernelCallingConvEv")
  //</editor-fold>
  public /*uint*/int getOpenCLKernelCallingConv() /*const*/ {
    return org.llvm.ir.CallingConv.C;
  }

  
  @Override public String toString() {
    return "" + "Info=" + Info; // NOI18N
  }
}
