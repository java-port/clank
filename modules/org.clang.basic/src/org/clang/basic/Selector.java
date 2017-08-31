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

package org.clang.basic;

import java.util.Comparator;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import static org.clang.basic.impl.IdentifierTableStatics.startsWithWord;
import org.clang.basic.impl.*;

/// \brief Smart pointer class that efficiently represents Objective-C method
/// names.
///
/// This class will either point to an IdentifierInfo or a
/// MultiKeywordSelector (which is private). This enables us to optimize
/// selectors that take no arguments and selectors that take 1 argument, which
/// accounts for 78% of all selectors in Cocoa.h.
//<editor-fold defaultstate="collapsed" desc="clang::Selector">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 628,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 613,
 FQN="clang::Selector", NM="_ZN5clang8SelectorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang8SelectorE")
//</editor-fold>
public class Selector implements Native.NativeComparable<Selector>, NativeCloneable<Selector> {
  /*friend  class Diagnostic*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::Selector::IdentifierInfoFlag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 631,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 616,
   FQN="clang::Selector::IdentifierInfoFlag", NM="_ZN5clang8Selector18IdentifierInfoFlagE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang8Selector18IdentifierInfoFlagE")
  //</editor-fold>
  private static final class/*enum*/ IdentifierInfoFlag {
    // Empty selector = 0.
    public static final /*uint*/int ZeroArg = 0x1;
    public static final /*uint*/int OneArg = 0x2;
    public static final /*uint*/int MultiArg = 0x3;
    public static final /*uint*/int ArgFlags = IdentifierInfoFlag.ZeroArg | IdentifierInfoFlag.OneArg;
  };
  /*friend*/public Object/*uintptr_t*/ $InfoPtr; // a pointer to the MultiKeywordSelector or IdentifierInfo. + JAVA $InfoPtrBits
  /*friend*/public /*uint*/byte $InfoPtrBits; // MANUAL_SEMANTIC
  
  //<editor-fold defaultstate="collapsed" desc="clang::Selector::Selector">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 640,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 625,
   FQN="clang::Selector::Selector", NM="_ZN5clang8SelectorC1EPNS_14IdentifierInfoEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang8SelectorC1EPNS_14IdentifierInfoEj")
  //</editor-fold>
  /*friend*//*private*/ Selector(IdentifierInfo /*P*/ II, /*uint*/int nArgs) {
    $InfoPtr = reinterpret_cast_Object/*uintptr_t*/(II);
    assert (($InfoPtrBits & IdentifierInfoFlag.ArgFlags) == 0) : "Insufficiently aligned IdentifierInfo";
    assert ($less_uint(nArgs, 2)) : "nArgs not equal to 0/1";
    $InfoPtrBits |= nArgs + 1;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Selector::Selector">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*introduced 2 tail params to help javac*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 646,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 631,
   FQN="clang::Selector::Selector", NM="_ZN5clang8SelectorC1EPNS_20MultiKeywordSelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang8SelectorC1EPNS_20MultiKeywordSelectorE")
  //</editor-fold>
  /*friend*//*private*/ Selector(MultiKeywordSelector /*P*/ SI, 
          JD$FAKE _dparm1, JD$FAKE _dparm2) {
    $InfoPtr = reinterpret_cast_Object/*uintptr_t*/(SI);
    assert (($InfoPtrBits & IdentifierInfoFlag.ArgFlags) == 0) : "Insufficiently aligned IdentifierInfo";
    $InfoPtrBits |= IdentifierInfoFlag.MultiArg;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Selector::getAsIdentifierInfo">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 652,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 637,
   FQN="clang::Selector::getAsIdentifierInfo", NM="_ZNK5clang8Selector19getAsIdentifierInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang8Selector19getAsIdentifierInfoEv")
  //</editor-fold>
  private IdentifierInfo /*P*/ getAsIdentifierInfo() /*const*/ {
    if ($less_uint(getIdentifierInfoFlag(), IdentifierInfoFlag.MultiArg)) {
      return (IdentifierInfo)$InfoPtr;
//      return reinterpret_cast(IdentifierInfo /*P*/ .class, InfoPtr & ~IdentifierInfoFlag.ArgFlags);
    }
    return null;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Selector::getMultiKeywordSelector">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 657,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 642,
   FQN="clang::Selector::getMultiKeywordSelector", NM="_ZNK5clang8Selector23getMultiKeywordSelectorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang8Selector23getMultiKeywordSelectorEv")
  //</editor-fold>
  private MultiKeywordSelector /*P*/ getMultiKeywordSelector() /*const*/ {
    return (MultiKeywordSelector)$InfoPtr;
//    return reinterpret_cast(MultiKeywordSelector /*P*/ .class, InfoPtr & ~IdentifierInfoFlag.ArgFlags);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Selector::getIdentifierInfoFlag">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 661,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 646,
   FQN="clang::Selector::getIdentifierInfoFlag", NM="_ZNK5clang8Selector21getIdentifierInfoFlagEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang8Selector21getIdentifierInfoFlagEv")
  //</editor-fold>
  private /*uint*/int getIdentifierInfoFlag() /*const*/ {
    return $InfoPtrBits & IdentifierInfoFlag.ArgFlags;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Selector::getMethodFamilyImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", line = 471,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", old_line = 470,
   FQN="clang::Selector::getMethodFamilyImpl", NM="_ZN5clang8Selector19getMethodFamilyImplES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang8Selector19getMethodFamilyImplES0_")
  //</editor-fold>
  private static ObjCMethodFamily getMethodFamilyImpl(Selector sel) {
    IdentifierInfo /*P*/ first = sel.getIdentifierInfoForSlot(0);
    if (!(first != null)) {
      return ObjCMethodFamily.OMF_None;
    }
    
    StringRef name = first.getName();
    if (sel.isUnarySelector()) {
      if ($eq_StringRef(/*NO_COPY*/name, /*STRINGREF_STR*/"autorelease")) {
        return ObjCMethodFamily.OMF_autorelease;
      }
      if ($eq_StringRef(/*NO_COPY*/name, /*STRINGREF_STR*/"dealloc")) {
        return ObjCMethodFamily.OMF_dealloc;
      }
      if ($eq_StringRef(/*NO_COPY*/name, /*STRINGREF_STR*/"finalize")) {
        return ObjCMethodFamily.OMF_finalize;
      }
      if ($eq_StringRef(/*NO_COPY*/name, /*STRINGREF_STR*/"release")) {
        return ObjCMethodFamily.OMF_release;
      }
      if ($eq_StringRef(/*NO_COPY*/name, /*STRINGREF_STR*/"retain")) {
        return ObjCMethodFamily.OMF_retain;
      }
      if ($eq_StringRef(/*NO_COPY*/name, /*STRINGREF_STR*/"retainCount")) {
        return ObjCMethodFamily.OMF_retainCount;
      }
      if ($eq_StringRef(/*NO_COPY*/name, /*STRINGREF_STR*/"self")) {
        return ObjCMethodFamily.OMF_self;
      }
      if ($eq_StringRef(/*NO_COPY*/name, /*STRINGREF_STR*/"initialize")) {
        return ObjCMethodFamily.OMF_initialize;
      }
    }
    if ($eq_StringRef(/*NO_COPY*/name, /*STRINGREF_STR*/"performSelector")) {
      return ObjCMethodFamily.OMF_performSelector;
    }
    
    // The other method families may begin with a prefix of underscores.
    while (!name.empty() && name.front() == $$UNDERSCORE) {
      name.$assign$substr(1);
    }
    if (name.empty()) {
      return ObjCMethodFamily.OMF_None;
    }
    switch (name.front()) {
     case 'a':
      if (startsWithWord(/*NO_COPY*/name, /*STRINGREF_STR*/"alloc")) {
        return ObjCMethodFamily.OMF_alloc;
      }
      break;
     case 'c':
      if (startsWithWord(/*NO_COPY*/name, /*STRINGREF_STR*/"copy")) {
        return ObjCMethodFamily.OMF_copy;
      }
      break;
     case 'i':
      if (startsWithWord(/*NO_COPY*/name, /*STRINGREF_STR*/"init")) {
        return ObjCMethodFamily.OMF_init;
      }
      break;
     case 'm':
      if (startsWithWord(/*NO_COPY*/name, /*STRINGREF_STR*/"mutableCopy")) {
        return ObjCMethodFamily.OMF_mutableCopy;
      }
      break;
     case 'n':
      if (startsWithWord(/*NO_COPY*/name, /*STRINGREF_STR*/"new")) {
        return ObjCMethodFamily.OMF_new;
      }
      break;
     default:
      break;
    }
    
    return ObjCMethodFamily.OMF_None;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Selector::getStringFormatFamilyImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", line = 543,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", old_line = 542,
   FQN="clang::Selector::getStringFormatFamilyImpl", NM="_ZN5clang8Selector25getStringFormatFamilyImplES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang8Selector25getStringFormatFamilyImplES0_")
  //</editor-fold>
  private static ObjCStringFormatFamily getStringFormatFamilyImpl(Selector sel) {
    IdentifierInfo /*P*/ first = sel.getIdentifierInfoForSlot(0);
    if (!(first != null)) {
      return ObjCStringFormatFamily.SFF_None;
    }
    
    StringRef name = first.getName();
    switch (name.front()) {
     case 'a':
      if ($eq_StringRef(/*NO_COPY*/name, /*STRINGREF_STR*/"appendFormat")) {
        return ObjCStringFormatFamily.SFF_NSString;
      }
      break;
     case 'i':
      if ($eq_StringRef(/*NO_COPY*/name, /*STRINGREF_STR*/"initWithFormat")) {
        return ObjCStringFormatFamily.SFF_NSString;
      }
      break;
     case 'l':
      if ($eq_StringRef(/*NO_COPY*/name, /*STRINGREF_STR*/"localizedStringWithFormat")) {
        return ObjCStringFormatFamily.SFF_NSString;
      }
      break;
     case 's':
      if ($eq_StringRef(/*NO_COPY*/name, /*STRINGREF_STR*/"stringByAppendingFormat")
         || $eq_StringRef(/*NO_COPY*/name, /*STRINGREF_STR*/"stringWithFormat")) {
        return ObjCStringFormatFamily.SFF_NSString;
      }
      break;
    }
    return ObjCStringFormatFamily.SFF_None;
  }


/*public:*/
  /*friend  class SelectorTable*/ // only the SelectorTable can create these
  /*friend  class DeclarationName*/ // and the AST's DeclarationName.
  
  /// The default ctor should only be used when creating data structures that
  ///  will contain selectors.
  //<editor-fold defaultstate="collapsed" desc="clang::Selector::Selector">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 675,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 660,
   FQN="clang::Selector::Selector", NM="_ZN5clang8SelectorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang8SelectorC1Ev")
  //</editor-fold>
  /*friend*/public Selector() {
    /* : InfoPtr(0)*/ 
    //START JInit
    this.$InfoPtr = null;
    this.$InfoPtrBits = 0;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Selector::Selector">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 676,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 661,
   FQN="clang::Selector::Selector", NM="_ZN5clang8SelectorC1Ej",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang8SelectorC1Ej")
  //</editor-fold>
  /*friend*/public Selector(Object/*uintptr_t*/ V) {
    /* : InfoPtr(V)*/ 
    assert V instanceof std.pairTypeUChar : "unexpected getAsOpaquePtr changed type to " + NativeTrace.getIdentityStr(V) + "? Or other constructor wanted to invoke?";
    //START JInit
    this.$InfoPtr = ((std.pairTypeUChar<?>)V).first;
    this.$InfoPtrBits = ((std.pairTypeUChar<?>)V).second;
    //END JInit
  }

  
  /// operator==/!= - Indicate whether the specified selectors are identical.
  //<editor-fold defaultstate="collapsed" desc="clang::Selector::operator==">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 679,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 664,
   FQN="clang::Selector::operator==", NM="_ZNK5clang8SelectoreqES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang8SelectoreqES0_")
  //</editor-fold>
  public boolean $eq(Selector RHS) /*const*/ {
    return $InfoPtr == RHS.$InfoPtr && $InfoPtrBits == RHS.$InfoPtrBits;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Selector::operator!=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 682,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 667,
   FQN="clang::Selector::operator!=", NM="_ZNK5clang8SelectorneES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang8SelectorneES0_")
  //</editor-fold>
  public boolean $noteq(Selector RHS) /*const*/ {
    return !$eq(RHS);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Selector::getAsOpaquePtr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 685,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 670,
   FQN="clang::Selector::getAsOpaquePtr", NM="_ZNK5clang8Selector14getAsOpaquePtrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang8Selector14getAsOpaquePtrEv")
  //</editor-fold>
  public Object/*void P*/ getAsOpaquePtr() /*const*/ {
    return isNull() ? null : new std.pairPtrUChar<>($InfoPtr, $InfoPtrBits);
  }

  
  /// \brief Determine whether this is the empty selector.
  //<editor-fold defaultstate="collapsed" desc="clang::Selector::isNull">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 690,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 675,
   FQN="clang::Selector::isNull", NM="_ZNK5clang8Selector6isNullEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang8Selector6isNullEv")
  //</editor-fold>
  public boolean isNull() /*const*/ {
    return $InfoPtr == null && $InfoPtrBits == 0;
  }

  
  // Predicates to identify the selector type.
  //<editor-fold defaultstate="collapsed" desc="clang::Selector::isKeywordSelector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 693,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 678,
   FQN="clang::Selector::isKeywordSelector", NM="_ZNK5clang8Selector17isKeywordSelectorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang8Selector17isKeywordSelectorEv")
  //</editor-fold>
  public boolean isKeywordSelector() /*const*/ {
    return getIdentifierInfoFlag() != IdentifierInfoFlag.ZeroArg;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Selector::isUnarySelector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 696,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 681,
   FQN="clang::Selector::isUnarySelector", NM="_ZNK5clang8Selector15isUnarySelectorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang8Selector15isUnarySelectorEv")
  //</editor-fold>
  public boolean isUnarySelector() /*const*/ {
    return getIdentifierInfoFlag() == IdentifierInfoFlag.ZeroArg;
  }

  // end namespace clang.
  //<editor-fold defaultstate="collapsed" desc="clang::Selector::getNumArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", line = 399,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", old_line = 398,
   FQN="clang::Selector::getNumArgs", NM="_ZNK5clang8Selector10getNumArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZNK5clang8Selector10getNumArgsEv")
  //</editor-fold>
  public /*uint*/int getNumArgs() /*const*/ {
    /*uint*/int IIF = getIdentifierInfoFlag();
    if ($lesseq_uint(IIF, IdentifierInfoFlag.ZeroArg)) {
      return 0;
    }
    if (IIF == IdentifierInfoFlag.OneArg) {
      return 1;
    }
    // We point to a MultiKeywordSelector.
    MultiKeywordSelector /*P*/ SI = getMultiKeywordSelector();
    return SI.getNumArgs();
  }


  
  /// \brief Retrieve the identifier at a given position in the selector.
  ///
  /// Note that the identifier pointer returned may be NULL. Clients that only
  /// care about the text of the identifier string, and not the specific, 
  /// uniqued identifier pointer, should use \c getNameForSlot(), which returns
  /// an empty string when the identifier pointer would be NULL.
  ///
  /// \param argIndex The index for which we want to retrieve the identifier.
  /// This index shall be less than \c getNumArgs() unless this is a keyword
  /// selector, in which case 0 is the only permissible value.
  ///
  /// \returns the uniqued identifier for this slot, or NULL if this slot has
  /// no corresponding identifier.
  
  /// \brief Retrieve the identifier at a given position in the selector.
  ///
  /// Note that the identifier pointer returned may be NULL. Clients that only
  /// care about the text of the identifier string, and not the specific, 
  /// uniqued identifier pointer, should use \c getNameForSlot(), which returns
  /// an empty string when the identifier pointer would be NULL.
  ///
  /// \param argIndex The index for which we want to retrieve the identifier.
  /// This index shall be less than \c getNumArgs() unless this is a keyword
  /// selector, in which case 0 is the only permissible value.
  ///
  /// \returns the uniqued identifier for this slot, or NULL if this slot has
  /// no corresponding identifier.
  //<editor-fold defaultstate="collapsed" desc="clang::Selector::getIdentifierInfoForSlot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", line = 410,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", old_line = 409,
   FQN="clang::Selector::getIdentifierInfoForSlot", NM="_ZNK5clang8Selector24getIdentifierInfoForSlotEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZNK5clang8Selector24getIdentifierInfoForSlotEj")
  //</editor-fold>
  public IdentifierInfo /*P*/ getIdentifierInfoForSlot(/*uint*/int argIndex) /*const*/ {
    if ($less_uint(getIdentifierInfoFlag(), IdentifierInfoFlag.MultiArg)) {
      assert (argIndex == 0) : "illegal keyword index";
      return getAsIdentifierInfo();
    }
    // We point to a MultiKeywordSelector.
    MultiKeywordSelector /*P*/ SI = getMultiKeywordSelector();
    return SI.getIdentifierInfoForSlot(argIndex);
  }


  
  /// \brief Retrieve the name at a given position in the selector.
  ///
  /// \param argIndex The index for which we want to retrieve the name.
  /// This index shall be less than \c getNumArgs() unless this is a keyword
  /// selector, in which case 0 is the only permissible value.
  ///
  /// \returns the name for this slot, which may be the empty string if no
  /// name was supplied.
  
  /// \brief Retrieve the name at a given position in the selector.
  ///
  /// \param argIndex The index for which we want to retrieve the name.
  /// This index shall be less than \c getNumArgs() unless this is a keyword
  /// selector, in which case 0 is the only permissible value.
  ///
  /// \returns the name for this slot, which may be the empty string if no
  /// name was supplied.
  //<editor-fold defaultstate="collapsed" desc="clang::Selector::getNameForSlot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", line = 420,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", old_line = 419,
   FQN="clang::Selector::getNameForSlot", NM="_ZNK5clang8Selector14getNameForSlotEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZNK5clang8Selector14getNameForSlotEj")
  //</editor-fold>
  public StringRef getNameForSlot(/*uint*/int argIndex) /*const*/ {
    IdentifierInfo /*P*/ II = getIdentifierInfoForSlot(argIndex);
    return (II != null) ? II.getName() : new StringRef();
  }


  
  /// \brief Derive the full selector name (e.g. "foo:bar:") and return
  /// it as an std::string.
  
  /// \brief Derive the full selector name (e.g. "foo:bar:") and return
  /// it as an std::string.
  //<editor-fold defaultstate="collapsed" desc="clang::Selector::getAsString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", line = 437,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", old_line = 436,
   FQN="clang::Selector::getAsString", NM="_ZNK5clang8Selector11getAsStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZNK5clang8Selector11getAsStringEv")
  //</editor-fold>
  public std.string getAsString() /*const*/ {
    if ($InfoPtr == null) {
      return new std.string(/*KEEP_STR*/"<null selector>");
    }
    if ($less_uint(getIdentifierInfoFlag(), IdentifierInfoFlag.MultiArg)) {
      IdentifierInfo /*P*/ II = getAsIdentifierInfo();
      
      // If the number of arguments is 0 then II is guaranteed to not be null.
      if (getNumArgs() == 0) {
        return II.getName().$string();
      }
      if (!(II != null)) {
        return new std.string(/*KEEP_STR*/$COLON);
      }
      
      return $add_str_T(II.getName().str(), /*KEEP_STR*/":");
    }
    
    // We have a multiple keyword selector.
    return getMultiKeywordSelector().getName();
  }


  
  /// \brief Prints the full selector name (e.g. "foo:bar:").
  
  /// \brief Prints the full selector name (e.g. "foo:bar:").
  //<editor-fold defaultstate="collapsed" desc="clang::Selector::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", line = 458,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", old_line = 457,
   FQN="clang::Selector::print", NM="_ZNK5clang8Selector5printERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZNK5clang8Selector5printERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void print(raw_ostream /*&*/ OS) /*const*/ {
    OS.$out(getAsString());
  }


  
  /// \brief Derive the conventional family of this method.
  //<editor-fold defaultstate="collapsed" desc="clang::Selector::getMethodFamily">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 735,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 720,
   FQN="clang::Selector::getMethodFamily", NM="_ZNK5clang8Selector15getMethodFamilyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang8Selector15getMethodFamilyEv")
  //</editor-fold>
  public ObjCMethodFamily getMethodFamily() /*const*/ {
    return getMethodFamilyImpl(new Selector(/*Deref*/this));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Selector::getStringFormatFamily">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 739,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 724,
   FQN="clang::Selector::getStringFormatFamily", NM="_ZNK5clang8Selector21getStringFormatFamilyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang8Selector21getStringFormatFamilyEv")
  //</editor-fold>
  public ObjCStringFormatFamily getStringFormatFamily() /*const*/ {
    return getStringFormatFamilyImpl(new Selector(/*Deref*/this));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Selector::getEmptyMarker">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 743,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 728,
   FQN="clang::Selector::getEmptyMarker", NM="_ZN5clang8Selector14getEmptyMarkerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang8Selector14getEmptyMarkerEv")
  //</editor-fold>
  public static Selector getEmptyMarker() {
//    return new Selector(((Object/*uintptr_t*/)(-1)));
    return new Selector(new std.pairPtrUChar<>(null, (byte)-1));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Selector::getTombstoneMarker">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 746,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 731,
   FQN="clang::Selector::getTombstoneMarker", NM="_ZN5clang8Selector18getTombstoneMarkerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang8Selector18getTombstoneMarkerEv")
  //</editor-fold>
  public static Selector getTombstoneMarker() {
//    return new Selector(((Object/*uintptr_t*/)(-2)));
    return new Selector(new std.pairPtrUChar<>(null, (byte)-2));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Selector::getInstTypeMethodFamily">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", line = 517,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", old_line = 516,
   FQN="clang::Selector::getInstTypeMethodFamily", NM="_ZN5clang8Selector23getInstTypeMethodFamilyES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang8Selector23getInstTypeMethodFamilyES0_")
  //</editor-fold>
  public static ObjCInstanceTypeFamily getInstTypeMethodFamily(Selector sel) {
    IdentifierInfo /*P*/ first = sel.getIdentifierInfoForSlot(0);
    if (!(first != null)) {
      return ObjCInstanceTypeFamily.OIT_None;
    }
    
    StringRef name = first.getName();
    if (name.empty()) {
      return ObjCInstanceTypeFamily.OIT_None;
    }
    switch (name.front()) {
     case 'a':
      if (startsWithWord(/*NO_COPY*/name, /*STRINGREF_STR*/"array")) {
        return ObjCInstanceTypeFamily.OIT_Array;
      }
      break;
     case 'd':
      if (startsWithWord(/*NO_COPY*/name, /*STRINGREF_STR*/"default")) {
        return ObjCInstanceTypeFamily.OIT_ReturnsSelf;
      }
      if (startsWithWord(/*NO_COPY*/name, /*STRINGREF_STR*/"dictionary")) {
        return ObjCInstanceTypeFamily.OIT_Dictionary;
      }
      break;
     case 's':
      if (startsWithWord(/*NO_COPY*/name, /*STRINGREF_STR*/"shared")) {
        return ObjCInstanceTypeFamily.OIT_ReturnsSelf;
      }
      if (startsWithWord(/*NO_COPY*/name, /*STRINGREF_STR*/"standard")) {
        return ObjCInstanceTypeFamily.OIT_Singleton;
      }
     case 'i':
      if (startsWithWord(/*NO_COPY*/name, /*STRINGREF_STR*/"init")) {
        return ObjCInstanceTypeFamily.OIT_Init;
      }
     default:
      break;
    }
    return ObjCInstanceTypeFamily.OIT_None;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Selector::Selector">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 628,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 613,
   FQN="clang::Selector::Selector", NM="_ZN5clang8SelectorC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang8SelectorC1ERKS0_")
  //</editor-fold>
  /*friend*/public /*inline*/ Selector(/*const*/ Selector /*&*/ $Prm0) {
    /* : InfoPtr(.InfoPtr)*/ 
    //START JInit
    this.$InfoPtr = $Prm0.$InfoPtr;
    this.$InfoPtrBits = $Prm0.$InfoPtrBits;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Selector::Selector">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 628,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 613,
   FQN="clang::Selector::Selector", NM="_ZN5clang8SelectorC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang8SelectorC1EOS0_")
  //</editor-fold>
  /*friend*/public /*inline*/ Selector(JD$Move _dparam, Selector /*&&*/$Prm0) {
    /* : InfoPtr(static_cast<Selector &&>().InfoPtr)*/ 
    //START JInit
    this.$InfoPtr = $Prm0.$InfoPtr;
    this.$InfoPtrBits = $Prm0.$InfoPtrBits;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Selector::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 628,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 613,
   FQN="clang::Selector::operator=", NM="_ZN5clang8SelectoraSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang8SelectoraSERKS0_")
  //</editor-fold>
  public /*inline*/ Selector /*&*/ $assign(/*const*/ Selector /*&*/ $Prm0) {
    this.$InfoPtr = $Prm0.$InfoPtr;
    this.$InfoPtrBits = $Prm0.$InfoPtrBits;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Selector::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 628,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 613,
   FQN="clang::Selector::operator=", NM="_ZN5clang8SelectoraSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang8SelectoraSEOS0_")
  //</editor-fold>
  public /*inline*/ Selector /*&*/ $assignMove(Selector /*&&*/$Prm0) {
    assert this != $Prm0;
    this.$InfoPtr = $Prm0.$InfoPtr;
    this.$InfoPtrBits = $Prm0.$InfoPtrBits;
    $Prm0.$InfoPtr = null;
    $Prm0.$InfoPtrBits = 0;
    return /*Deref*/this;
  }

  @Override
  public Selector clone() {
    return new Selector(this);
  }
  
  public static final Selector DEFAULT = new Selector();
  
  public static final Comparator<Selector> COMPARATOR = new Comparator<Selector>() {
    @Override
    public int compare(Selector o1, Selector o2) {
      // JAVA: slow version of compare
      if (o1.$eq(o2)) {
        return 0;
      }
      if (o1.$InfoPtr == o2.$InfoPtr) {
        return Unsigned.$compare_uchar(o1.$InfoPtrBits, o2.$InfoPtrBits);
      }
      return Native.compare$JavaRef(o1.$InfoPtr, o2.$InfoPtr);
    }
  };
  
  public String toString() {
    return "$" + $InfoPtrBits + ":InfoPtr=" + $InfoPtr; // NOI18N
  }
}
