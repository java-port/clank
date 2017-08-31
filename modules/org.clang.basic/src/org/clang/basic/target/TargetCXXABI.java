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

package org.clang.basic.target;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.support.*;
import org.clang.basic.target.*;


/// \brief The basic abstraction for the target C++ ABI.
//<editor-fold defaultstate="collapsed" desc="clang::TargetCXXABI">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetCXXABI.h", line = 25,
 FQN="clang::TargetCXXABI", NM="_ZN5clang12TargetCXXABIE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN5clang12TargetCXXABIE")
//</editor-fold>
public class TargetCXXABI {
/*public:*/
  /// \brief The basic C++ ABI kind.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetCXXABI::Kind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetCXXABI.h", line = 28,
   FQN="clang::TargetCXXABI::Kind", NM="_ZN5clang12TargetCXXABI4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN5clang12TargetCXXABI4KindE")
  //</editor-fold>
  public enum Kind implements Native.ComparableLower {
    /// The generic Itanium ABI is the standard ABI of most open-source
    /// and Unix-like platforms.  It is the primary ABI targeted by
    /// many compilers, including Clang and GCC.
    ///
    /// It is documented here:
    ///   http://www.codesourcery.com/public/cxx-abi/
    GenericItanium(0),
    
    /// The generic ARM ABI is a modified version of the Itanium ABI
    /// proposed by ARM for use on ARM-based platforms.
    ///
    /// These changes include:
    ///   - the representation of member function pointers is adjusted
    ///     to not conflict with the 'thumb' bit of ARM function pointers;
    ///   - constructors and destructors return 'this';
    ///   - guard variables are smaller;
    ///   - inline functions are never key functions;
    ///   - array cookies have a slightly different layout;
    ///   - additional convenience functions are specified;
    ///   - and more!
    ///
    /// It is documented here:
    ///    http://infocenter.arm.com
    ///                    /help/topic/com.arm.doc.ihi0041c/IHI0041C_cppabi.pdf
    GenericARM(GenericItanium.getValue() + 1),
    
    /// The iOS ABI is a partial implementation of the ARM ABI.
    /// Several of the features of the ARM ABI were not fully implemented
    /// in the compilers that iOS was launched with.
    ///
    /// Essentially, the iOS ABI includes the ARM changes to:
    ///   - member function pointers,
    ///   - guard variables,
    ///   - array cookies, and
    ///   - constructor/destructor signatures.
    iOS(GenericARM.getValue() + 1),
    
    /// The iOS 64-bit ABI is follows ARM's published 64-bit ABI more
    /// closely, but we don't guarantee to follow it perfectly.
    ///
    /// It is documented here:
    ///    http://infocenter.arm.com
    ///                  /help/topic/com.arm.doc.ihi0059a/IHI0059A_cppabi64.pdf
    iOS64(iOS.getValue() + 1),
    
    /// WatchOS is a modernisation of the iOS ABI, which roughly means it's
    /// the iOS64 ABI ported to 32-bits. The primary difference from iOS64 is
    /// that RTTI objects must still be unique at the moment.
    WatchOS(iOS64.getValue() + 1),
    
    /// The generic AArch64 ABI is also a modified version of the Itanium ABI,
    /// but it has fewer divergences than the 32-bit ARM ABI.
    ///
    /// The relevant changes from the generic ABI in this case are:
    ///   - representation of member function pointers adjusted as in ARM.
    ///   - guard variables  are smaller.
    GenericAArch64(WatchOS.getValue() + 1),
    
    /// The generic Mips ABI is a modified version of the Itanium ABI.
    ///
    /// At the moment, only change from the generic ABI in this case is:
    ///   - representation of member function pointers adjusted as in ARM.
    GenericMIPS(GenericAArch64.getValue() + 1),
    
    /// The WebAssembly ABI is a modified version of the Itanium ABI.
    ///
    /// The changes from the Itanium ABI are:
    ///   - representation of member function pointers is adjusted, as in ARM;
    ///   - member functions are not specially aligned;
    ///   - constructors and destructors return 'this', as in ARM;
    ///   - guard variables are 32-bit on wasm32, as in ARM;
    ///   - unused bits of guard variables are reserved, as in ARM;
    ///   - inline functions are never key functions, as in ARM;
    ///   - C++11 POD rules are used for tail padding, as in iOS64.
    ///
    /// TODO: At present the WebAssembly ABI is not considered stable, so none
    /// of these details is necessarily final yet.
    WebAssembly(GenericMIPS.getValue() + 1),
    
    /// The Microsoft ABI is the ABI used by Microsoft Visual Studio (and
    /// compatible compilers).
    ///
    /// FIXME: should this be split into Win32 and Win64 variants?
    ///
    /// Only scattered and incomplete official documentation exists.
    Microsoft(WebAssembly.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Kind valueOf(int val) {
      Kind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Kind[] VALUES;
      private static final Kind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Kind kind : Kind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Kind[min < 0 ? (1-min) : 0];
        VALUES = new Kind[max >= 0 ? (1+max) : 0];
        for (Kind kind : Kind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private Kind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Kind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Kind)obj).value);}
    //</editor-fold>
  };
/*private:*/
  // Right now, this class is passed around as a cheap value type.
  // If you add more members, especially non-POD members, please
  // audit the users to pass it by reference instead.
  private Kind TheKind;
/*public:*/
  /// A bogus initialization of the platform ABI.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetCXXABI::TargetCXXABI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetCXXABI.h", line = 125,
   FQN="clang::TargetCXXABI::TargetCXXABI", NM="_ZN5clang12TargetCXXABIC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN5clang12TargetCXXABIC1Ev")
  //</editor-fold>
  public TargetCXXABI() {
    /* : TheKind(GenericItanium)*/ 
    //START JInit
    this.TheKind = Kind.GenericItanium;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TargetCXXABI::TargetCXXABI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetCXXABI.h", line = 127,
   FQN="clang::TargetCXXABI::TargetCXXABI", NM="_ZN5clang12TargetCXXABIC1ENS0_4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN5clang12TargetCXXABIC1ENS0_4KindE")
  //</editor-fold>
  public TargetCXXABI(Kind kind) {
    /* : TheKind(kind)*/ 
    //START JInit
    this.TheKind = kind;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TargetCXXABI::set">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetCXXABI.h", line = 129,
   FQN="clang::TargetCXXABI::set", NM="_ZN5clang12TargetCXXABI3setENS0_4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN5clang12TargetCXXABI3setENS0_4KindE")
  //</editor-fold>
  public void set(Kind kind) {
    TheKind = kind;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TargetCXXABI::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetCXXABI.h", line = 133,
   FQN="clang::TargetCXXABI::getKind", NM="_ZNK5clang12TargetCXXABI7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZNK5clang12TargetCXXABI7getKindEv")
  //</editor-fold>
  public Kind getKind() /*const*/ {
    return TheKind;
  }

  
  /// \brief Does this ABI generally fall into the Itanium family of ABIs?
  //<editor-fold defaultstate="collapsed" desc="clang::TargetCXXABI::isItaniumFamily">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetCXXABI.h", line = 136,
   FQN="clang::TargetCXXABI::isItaniumFamily", NM="_ZNK5clang12TargetCXXABI15isItaniumFamilyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZNK5clang12TargetCXXABI15isItaniumFamilyEv")
  //</editor-fold>
  public boolean isItaniumFamily() /*const*/ {
    switch (getKind()) {
     case GenericAArch64:
     case GenericItanium:
     case GenericARM:
     case iOS:
     case iOS64:
     case WatchOS:
     case GenericMIPS:
     case WebAssembly:
      return true;
     case Microsoft:
      return false;
    }
    throw new llvm_unreachable("bad ABI kind");
  }

  
  /// \brief Is this ABI an MSVC-compatible ABI?
  //<editor-fold defaultstate="collapsed" desc="clang::TargetCXXABI::isMicrosoft">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetCXXABI.h", line = 155,
   FQN="clang::TargetCXXABI::isMicrosoft", NM="_ZNK5clang12TargetCXXABI11isMicrosoftEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZNK5clang12TargetCXXABI11isMicrosoftEv")
  //</editor-fold>
  public boolean isMicrosoft() /*const*/ {
    switch (getKind()) {
     case GenericAArch64:
     case GenericItanium:
     case GenericARM:
     case iOS:
     case iOS64:
     case WatchOS:
     case GenericMIPS:
     case WebAssembly:
      return false;
     case Microsoft:
      return true;
    }
    throw new llvm_unreachable("bad ABI kind");
  }

  
  /// \brief Are member functions differently aligned?
  ///
  /// Many Itanium-style C++ ABIs require member functions to be aligned, so
  /// that a pointer to such a function is guaranteed to have a zero in the
  /// least significant bit, so that pointers to member functions can use that
  /// bit to distinguish between virtual and non-virtual functions. However,
  /// some Itanium-style C++ ABIs differentiate between virtual and non-virtual
  /// functions via other means, and consequently don't require that member
  /// functions be aligned.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetCXXABI::areMemberFunctionsAligned">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetCXXABI.h", line = 182,
   FQN="clang::TargetCXXABI::areMemberFunctionsAligned", NM="_ZNK5clang12TargetCXXABI25areMemberFunctionsAlignedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZNK5clang12TargetCXXABI25areMemberFunctionsAlignedEv")
  //</editor-fold>
  public boolean areMemberFunctionsAligned() /*const*/ {
    switch (getKind()) {
     case WebAssembly:
      // WebAssembly doesn't require any special alignment for member functions.
      return false;
     case GenericARM:
     case GenericAArch64:
     case GenericMIPS:
     case GenericItanium:
     case iOS:
     case iOS64:
     case WatchOS:
     case Microsoft:
      // TODO: ARM-style pointers to member functions put the discriminator in
      //       the this adjustment, so they don't require functions to have any
      //       special alignment and could therefore also return false.
      return true;
    }
    throw new llvm_unreachable("bad ABI kind");
  }

  
  /// \brief Is the default C++ member function calling convention
  /// the same as the default calling convention?
  //<editor-fold defaultstate="collapsed" desc="clang::TargetCXXABI::isMemberFunctionCCDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetCXXABI.h", line = 205,
   FQN="clang::TargetCXXABI::isMemberFunctionCCDefault", NM="_ZNK5clang12TargetCXXABI25isMemberFunctionCCDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZNK5clang12TargetCXXABI25isMemberFunctionCCDefaultEv")
  //</editor-fold>
  public boolean isMemberFunctionCCDefault() /*const*/ {
    // Right now, this is always false for Microsoft.
    return !isMicrosoft();
  }

  
  /// Are arguments to a call destroyed left to right in the callee?
  /// This is a fundamental language change, since it implies that objects
  /// passed by value do *not* live to the end of the full expression.
  /// Temporaries passed to a function taking a const reference live to the end
  /// of the full expression as usual.  Both the caller and the callee must
  /// have access to the destructor, while only the caller needs the
  /// destructor if this is false.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetCXXABI::areArgsDestroyedLeftToRightInCallee">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetCXXABI.h", line = 217,
   FQN="clang::TargetCXXABI::areArgsDestroyedLeftToRightInCallee", NM="_ZNK5clang12TargetCXXABI35areArgsDestroyedLeftToRightInCalleeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZNK5clang12TargetCXXABI35areArgsDestroyedLeftToRightInCalleeEv")
  //</editor-fold>
  public boolean areArgsDestroyedLeftToRightInCallee() /*const*/ {
    return isMicrosoft();
  }

  
  /// \brief Does this ABI have different entrypoints for complete-object
  /// and base-subobject constructors?
  //<editor-fold defaultstate="collapsed" desc="clang::TargetCXXABI::hasConstructorVariants">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetCXXABI.h", line = 223,
   FQN="clang::TargetCXXABI::hasConstructorVariants", NM="_ZNK5clang12TargetCXXABI22hasConstructorVariantsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZNK5clang12TargetCXXABI22hasConstructorVariantsEv")
  //</editor-fold>
  public boolean hasConstructorVariants() /*const*/ {
    return isItaniumFamily();
  }

  
  /// \brief Does this ABI allow virtual bases to be primary base classes?
  //<editor-fold defaultstate="collapsed" desc="clang::TargetCXXABI::hasPrimaryVBases">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetCXXABI.h", line = 228,
   FQN="clang::TargetCXXABI::hasPrimaryVBases", NM="_ZNK5clang12TargetCXXABI16hasPrimaryVBasesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZNK5clang12TargetCXXABI16hasPrimaryVBasesEv")
  //</editor-fold>
  public boolean hasPrimaryVBases() /*const*/ {
    return isItaniumFamily();
  }

  
  /// \brief Does this ABI use key functions?  If so, class data such as the
  /// vtable is emitted with strong linkage by the TU containing the key
  /// function.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetCXXABI::hasKeyFunctions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetCXXABI.h", line = 235,
   FQN="clang::TargetCXXABI::hasKeyFunctions", NM="_ZNK5clang12TargetCXXABI15hasKeyFunctionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZNK5clang12TargetCXXABI15hasKeyFunctionsEv")
  //</editor-fold>
  public boolean hasKeyFunctions() /*const*/ {
    return isItaniumFamily();
  }

  
  /// \brief Can an out-of-line inline function serve as a key function?
  ///
  /// This flag is only useful in ABIs where type data (for example,
  /// vtables and type_info objects) are emitted only after processing
  /// the definition of a special "key" virtual function.  (This is safe
  /// because the ODR requires that every virtual function be defined
  /// somewhere in a program.)  This usually permits such data to be
  /// emitted in only a single object file, as opposed to redundantly
  /// in every object file that requires it.
  ///
  /// One simple and common definition of "key function" is the first
  /// virtual function in the class definition which is not defined there.
  /// This rule works very well when that function has a non-inline
  /// definition in some non-header file.  Unfortunately, when that
  /// function is defined inline, this rule requires the type data
  /// to be emitted weakly, as if there were no key function.
  ///
  /// The ARM ABI observes that the ODR provides an additional guarantee:
  /// a virtual function is always ODR-used, so if it is defined inline,
  /// that definition must appear in every translation unit that defines
  /// the class.  Therefore, there is no reason to allow such functions
  /// to serve as key functions.
  ///
  /// Because this changes the rules for emitting type data,
  /// it can cause type data to be emitted with both weak and strong
  /// linkage, which is not allowed on all platforms.  Therefore,
  /// exploiting this observation requires an ABI break and cannot be
  /// done on a generic Itanium platform.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetCXXABI::canKeyFunctionBeInline">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetCXXABI.h", line = 267,
   FQN="clang::TargetCXXABI::canKeyFunctionBeInline", NM="_ZNK5clang12TargetCXXABI22canKeyFunctionBeInlineEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZNK5clang12TargetCXXABI22canKeyFunctionBeInlineEv")
  //</editor-fold>
  public boolean canKeyFunctionBeInline() /*const*/ {
    switch (getKind()) {
     case GenericARM:
     case iOS64:
     case WebAssembly:
     case WatchOS:
      return false;
     case GenericAArch64:
     case GenericItanium:
     case iOS: // old iOS compilers did not follow this rule
     case Microsoft:
     case GenericMIPS:
      return true;
    }
    throw new llvm_unreachable("bad ABI kind");
  }

  
  /// When is record layout allowed to allocate objects in the tail
  /// padding of a base class?
  ///
  /// This decision cannot be changed without breaking platform ABI
  /// compatibility, and yet it is tied to language guarantees which
  /// the committee has so far seen fit to strengthen no less than
  /// three separate times:
  ///   - originally, there were no restrictions at all;
  ///   - C++98 declared that objects could not be allocated in the
  ///     tail padding of a POD type;
  ///   - C++03 extended the definition of POD to include classes
  ///     containing member pointers; and
  ///   - C++11 greatly broadened the definition of POD to include
  ///     all trivial standard-layout classes.
  /// Each of these changes technically took several existing
  /// platforms and made them permanently non-conformant.
  //<editor-fold defaultstate="collapsed" desc="clang::TargetCXXABI::TailPaddingUseRules">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetCXXABI.h", line = 301,
   FQN="clang::TargetCXXABI::TailPaddingUseRules", NM="_ZN5clang12TargetCXXABI19TailPaddingUseRulesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN5clang12TargetCXXABI19TailPaddingUseRulesE")
  //</editor-fold>
  public enum TailPaddingUseRules implements Native.ComparableLower {
    /// The tail-padding of a base class is always theoretically
    /// available, even if it's POD.  This is not strictly conforming
    /// in any language mode.
    AlwaysUseTailPadding(0),
    
    /// Only allocate objects in the tail padding of a base class if
    /// the base class is not POD according to the rules of C++ TR1.
    /// This is non-strictly conforming in C++11 mode.
    UseTailPaddingUnlessPOD03(AlwaysUseTailPadding.getValue() + 1),
    
    /// Only allocate objects in the tail padding of a base class if
    /// the base class is not POD according to the rules of C++11.
    UseTailPaddingUnlessPOD11(UseTailPaddingUnlessPOD03.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static TailPaddingUseRules valueOf(int val) {
      TailPaddingUseRules out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final TailPaddingUseRules[] VALUES;
      private static final TailPaddingUseRules[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (TailPaddingUseRules kind : TailPaddingUseRules.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new TailPaddingUseRules[min < 0 ? (1-min) : 0];
        VALUES = new TailPaddingUseRules[max >= 0 ? (1+max) : 0];
        for (TailPaddingUseRules kind : TailPaddingUseRules.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private TailPaddingUseRules(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((TailPaddingUseRules)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((TailPaddingUseRules)obj).value);}
    //</editor-fold>
  };
  //<editor-fold defaultstate="collapsed" desc="clang::TargetCXXABI::getTailPaddingUseRules">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetCXXABI.h", line = 316,
   FQN="clang::TargetCXXABI::getTailPaddingUseRules", NM="_ZNK5clang12TargetCXXABI22getTailPaddingUseRulesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZNK5clang12TargetCXXABI22getTailPaddingUseRulesEv")
  //</editor-fold>
  public TailPaddingUseRules getTailPaddingUseRules() /*const*/ {
    switch (getKind()) {
     case GenericItanium:
     case GenericAArch64:
     case GenericARM:
     case iOS:
     case GenericMIPS:
      // To preserve binary compatibility, the generic Itanium ABI has
      // permanently locked the definition of POD to the rules of C++ TR1,
      // and that trickles down to derived ABIs.
      return TailPaddingUseRules.UseTailPaddingUnlessPOD03;
     case iOS64:
     case WebAssembly:
     case WatchOS:
      
      // iOS on ARM64 and WebAssembly use the C++11 POD rules.  They do not honor
      // the Itanium exception about classes with over-large bitfields.
      return TailPaddingUseRules.UseTailPaddingUnlessPOD11;
     case Microsoft:
      
      // MSVC always allocates fields in the tail-padding of a base class
      // subobject, even if they're POD.
      return TailPaddingUseRules.AlwaysUseTailPadding;
    }
    throw new llvm_unreachable("bad ABI kind");
  }

  
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetCXXABI.h", line = 343,
   FQN="clang::operator==", NM="_ZN5clangeqERKNS_12TargetCXXABIES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN5clangeqERKNS_12TargetCXXABIES2_")
  //</editor-fold>
  public static boolean $eq_TargetCXXABI$C(/*const*/ TargetCXXABI /*&*/ left, /*const*/ TargetCXXABI /*&*/ right) {
    return left.getKind() == right.getKind();
  }

  
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetCXXABI.h", line = 347,
   FQN="clang::operator!=", NM="_ZN5clangneERKNS_12TargetCXXABIES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN5clangneERKNS_12TargetCXXABIES2_")
  //</editor-fold>
  public static boolean $noteq_TargetCXXABI$C(/*const*/ TargetCXXABI /*&*/ left, /*const*/ TargetCXXABI /*&*/ right) {
    return !($eq_TargetCXXABI$C(left, right));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TargetCXXABI::TargetCXXABI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetCXXABI.h", line = 25,
   FQN="clang::TargetCXXABI::TargetCXXABI", NM="_ZN5clang12TargetCXXABIC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN5clang12TargetCXXABIC1ERKS0_")
  //</editor-fold>
  public /*inline*/ TargetCXXABI(/*const*/ TargetCXXABI /*&*/ $Prm0) {
    /* : TheKind(.TheKind)*/ 
    //START JInit
    this.TheKind = $Prm0.TheKind;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TargetCXXABI::TargetCXXABI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetCXXABI.h", line = 25,
   FQN="clang::TargetCXXABI::TargetCXXABI", NM="_ZN5clang12TargetCXXABIC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN5clang12TargetCXXABIC1EOS0_")
  //</editor-fold>
  public /*inline*/ TargetCXXABI(JD$Move _dparam, TargetCXXABI /*&&*/$Prm0) {
    /* : TheKind(static_cast<TargetCXXABI &&>().TheKind)*/ 
    //START JInit
    this.TheKind = $Prm0.TheKind;
    //END JInit
  }

  
  public String toString() {
    return "" + "TheKind=" + TheKind; // NOI18N
  }
}
