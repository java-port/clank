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
package org.llvm.ir.mdconst;

import org.clank.support.*;
import static org.llvm.support.llvm.*;
import org.llvm.ir.*;
import static org.llvm.ir.java.IrRTTI.*;
import org.llvm.ir.java.*;


//<editor-fold defaultstate="collapsed" desc="static type MdconstGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.ir.mdconst.MdconstGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=Tpl__ZN4llvm7mdconst11dyn_extractEOT0_R_ZTSNSt9enable_ifIXsr6detail14IsValidPointerIT_T0_EE5valueEPS0_E4typeE;Tpl__ZN4llvm7mdconst15extract_or_nullEOT0_R_ZTSNSt9enable_ifIXsr6detail14IsValidPointerIT_T0_EE5valueEPS0_E4typeE;Tpl__ZN4llvm7mdconst19dyn_extract_or_nullEOT0_R_ZTSNSt9enable_ifIXsr6detail14IsValidPointerIT_T0_EE5valueEPS0_E4typeE;Tpl__ZN4llvm7mdconst4hasaEOT0_R_ZTSNSt9enable_ifIXsr6detail14IsValidPointerIT_T0_EE5valueEbE4typeE;Tpl__ZN4llvm7mdconst4hasaERT0_R_ZTSNSt9enable_ifIXsr6detail16IsValidReferenceIT_RT0_EE5valueEbE4typeE;Tpl__ZN4llvm7mdconst7extractEOT0_R_ZTSNSt9enable_ifIXsr6detail14IsValidPointerIT_T0_EE5valueEPS0_E4typeE;Tpl__ZN4llvm7mdconst7extractERT0_R_ZTSNSt9enable_ifIXsr6detail16IsValidReferenceIT_RT0_EE5valueEPS0_E4typeE; -static-type=MdconstGlobals -package=org.llvm.ir.mdconst")
//</editor-fold>
public final class MdconstGlobals {

// end namespace detail

/// \brief Check whether Metadata has a Value.
///
/// As an analogue to \a isa(), check whether \c MD has an \a Value inside of
/// type \c X.
/*template <class X, class Y> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::mdconst::hasa">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 494,
 FQN="llvm::mdconst::hasa", NM="Tpl__ZN4llvm7mdconst4hasaEOT0_R_ZTSNSt9enable_ifIXsr6detail14IsValidPointerIT_T0_EE5valueEbE4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=Tpl__ZN4llvm7mdconst4hasaEOT0_R_ZTSNSt9enable_ifIXsr6detail14IsValidPointerIT_T0_EE5valueEbE4typeE")
//</editor-fold>
public static /*inline*/ </*class*/ X extends Constant, /*class*/ Y extends GetMetadata> /*std::enable_if<IsValidPointer<X, Y>::value, boolean>::type*/
        boolean hasa$ValidPointer(Class<X> cls, final Y /*&&*/MD) {
  assert Native.$bool(MD) : "Null pointer sent into hasa";
  {
    ConstantAsMetadata /*P*/ V = dyn_cast_ConstantAsMetadata(MD.get());
    if (V != null) {
      return isa(cls, V.getValue());
    }
  }
  return false;
}

/*template <class X, class Y> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::mdconst::hasa">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 502,
 FQN="llvm::mdconst::hasa", NM="Tpl__ZN4llvm7mdconst4hasaERT0_R_ZTSNSt9enable_ifIXsr6detail16IsValidReferenceIT_RT0_EE5valueEbE4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=Tpl__ZN4llvm7mdconst4hasaERT0_R_ZTSNSt9enable_ifIXsr6detail16IsValidReferenceIT_RT0_EE5valueEbE4typeE")
//</editor-fold>
public static /*inline*/ </*class*/ X extends Constant, /*class*/ Y extends Metadata> /*std::enable_if<IsValidReference<X, Y  >::value, boolean>::type*/
        boolean hasa$ValidReference(Class<X> cls, final Y /*&*/ MD) {
  assert Native.$bool(MD) : "Null pointer sent into hasa";
  {
    ConstantAsMetadata /*P*/ V = dyn_cast_ConstantAsMetadata(MD);
    if (V != null) {
      return isa(cls, V.getValue());
    }
  }
  return false;
}


/// \brief Extract a Value from Metadata.
///
/// As an analogue to \a cast(), extract the \a Value subclass \c X from \c MD.
/*template <class X, class Y> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::mdconst::extract">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 512,
 FQN="llvm::mdconst::extract", NM="Tpl__ZN4llvm7mdconst7extractEOT0_R_ZTSNSt9enable_ifIXsr6detail14IsValidPointerIT_T0_EE5valueEPS0_E4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=Tpl__ZN4llvm7mdconst7extractEOT0_R_ZTSNSt9enable_ifIXsr6detail14IsValidPointerIT_T0_EE5valueEPS0_E4typeE")
//</editor-fold>
public static /*inline*/ </*class*/ X extends Constant, /*class*/ Y extends GetMetadata> /*std::enable_if<IsValidPointer<X, Y>::value, X  >::type*/
        X /*P*/ extract$ValidPointer(Class<X> cls, final Y /*&&*/MD) {
  return cast(cls, cast_ConstantAsMetadata(MD.get()).getValue());
}

/*template <class X, class Y> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::mdconst::extract">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 517,
 FQN="llvm::mdconst::extract", NM="Tpl__ZN4llvm7mdconst7extractERT0_R_ZTSNSt9enable_ifIXsr6detail16IsValidReferenceIT_RT0_EE5valueEPS0_E4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=Tpl__ZN4llvm7mdconst7extractERT0_R_ZTSNSt9enable_ifIXsr6detail16IsValidReferenceIT_RT0_EE5valueEPS0_E4typeE")
//</editor-fold>
public static /*inline*/ </*class*/ X extends Constant, /*class*/ Y extends Metadata> /*std::enable_if<IsValidReference<X, Y  >::value, X  >::type*/
        X /*P*/ extract$ValidReference(Class<X> cls, final Y /*&*/ MD) {
  return cast(cls, cast_ConstantAsMetadata(MD).getValue());
}


/// \brief Extract a Value from Metadata, allowing null.
///
/// As an analogue to \a cast_or_null(), extract the \a Value subclass \c X
/// from \c MD, allowing \c MD to be null.
/*template <class X, class Y> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::mdconst::extract_or_null">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 528,
 FQN="llvm::mdconst::extract_or_null", NM="Tpl__ZN4llvm7mdconst15extract_or_nullEOT0_R_ZTSNSt9enable_ifIXsr6detail14IsValidPointerIT_T0_EE5valueEPS0_E4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=Tpl__ZN4llvm7mdconst15extract_or_nullEOT0_R_ZTSNSt9enable_ifIXsr6detail14IsValidPointerIT_T0_EE5valueEPS0_E4typeE")
//</editor-fold>
public static /*inline*/ </*class*/ X extends Constant, /*class*/ Y extends GetMetadata> /*std::enable_if<IsValidPointer<X, Y>::value, X  >::type*/
        X /*P*/ extract_or_null$ValidPointer(Class<X> cls, final Y /*&&*/MD) {
  {
    ConstantAsMetadata /*P*/ V = cast_or_null_ConstantAsMetadata(MD.get());
    if (V != null) {
      return cast(cls, V.getValue());
    }
  }
  return null;
}


/// \brief Extract a Value from Metadata, if any.
///
/// As an analogue to \a dyn_cast_or_null(), extract the \a Value subclass \c X
/// from \c MD, return null if \c MD doesn't contain a \a Value or if the \a
/// Value it does contain is of the wrong subclass.
/*template <class X, class Y> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::mdconst::dyn_extract">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 541,
 FQN="llvm::mdconst::dyn_extract", NM="Tpl__ZN4llvm7mdconst11dyn_extractEOT0_R_ZTSNSt9enable_ifIXsr6detail14IsValidPointerIT_T0_EE5valueEPS0_E4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=Tpl__ZN4llvm7mdconst11dyn_extractEOT0_R_ZTSNSt9enable_ifIXsr6detail14IsValidPointerIT_T0_EE5valueEPS0_E4typeE")
//</editor-fold>
public static /*inline*/ </*class*/ X extends Constant, /*class*/ Y extends GetMetadata> /*std::enable_if<IsValidPointer<X, Y>::value, X  >::type*/
        X /*P*/ dyn_extract$ValidPointer(Class<X> cls, final Y /*&&*/MD) {
  {
    ConstantAsMetadata /*P*/ V = dyn_cast_ConstantAsMetadata(MD.get());
    if (V != null) {
      return dyn_cast(cls, V.getValue());
    }
  }
  return null;
}


/// \brief Extract a Value from Metadata, if any, allowing null.
///
/// As an analogue to \a dyn_cast_or_null(), extract the \a Value subclass \c X
/// from \c MD, return null if \c MD doesn't contain a \a Value or if the \a
/// Value it does contain is of the wrong subclass, allowing \c MD to be null.
/*template <class X, class Y> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::mdconst::dyn_extract_or_null">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 554,
 FQN="llvm::mdconst::dyn_extract_or_null", NM="Tpl__ZN4llvm7mdconst19dyn_extract_or_nullEOT0_R_ZTSNSt9enable_ifIXsr6detail14IsValidPointerIT_T0_EE5valueEPS0_E4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=Tpl__ZN4llvm7mdconst19dyn_extract_or_nullEOT0_R_ZTSNSt9enable_ifIXsr6detail14IsValidPointerIT_T0_EE5valueEPS0_E4typeE")
//</editor-fold>
public static /*inline*/ </*class*/ X extends Constant, /*class*/ Y extends GetMetadata> /*std::enable_if<IsValidPointer<X, Y>::value, X  >::type*/
        X /*P*/ dyn_extract_or_null$ValidPointer(Class<X> cls, final Y /*&&*/MD) {
  {
    ConstantAsMetadata /*P*/ V = dyn_cast_or_null_ConstantAsMetadata(MD.get());
    if (V != null) {
      return dyn_cast(cls, V.getValue());
    }
  }
  return null;
}
@Converted(kind = Converted.Kind.MANUAL_ADDED,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 554,
 FQN="llvm::mdconst::dyn_extract_or_null", NM="Tpl__ZN4llvm7mdconst19dyn_extract_or_nullEOT0_R_ZTSNSt9enable_ifIXsr6detail14IsValidPointerIT_T0_EE5valueEPS0_E4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=Tpl__ZN4llvm7mdconst19dyn_extract_or_nullEOT0_R_ZTSNSt9enable_ifIXsr6detail14IsValidPointerIT_T0_EE5valueEPS0_E4typeE")
//</editor-fold>
public static /*inline*/ </*class*/ X extends Constant, /*class*/ Y extends Metadata> /*std::enable_if<IsValidPointer<X, Y>::value, X  >::type*/
        X /*P*/ dyn_extract_or_null$ValidReference(Class<X> cls, final Y /*&&*/MD) {
  {
    ConstantAsMetadata /*P*/ V = dyn_cast_or_null_ConstantAsMetadata(MD);
    if (V != null) {
      return dyn_cast(cls, V.getValue());
    }
  }
  return null;
}

} // END OF class MdconstGlobals
