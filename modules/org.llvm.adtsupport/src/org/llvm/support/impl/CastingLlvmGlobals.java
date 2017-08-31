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
package org.llvm.support.impl;

import java.util.ArrayList;
import java.util.List;
import org.clank.support.*;
import org.llvm.support.*;


//<editor-fold defaultstate="collapsed" desc="static type CastingLlvmGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=Tpl__ZN4llvm12cast_or_nullEPT0_;Tpl__ZN4llvm12cast_or_nullERKT0_R_ZTSNSt9enable_ifIXntsr14is_simple_typeIT0_EE5valueEN4llvm10cast_rettyIT_KS0_E8ret_typeEE4typeE;Tpl__ZN4llvm12cast_or_nullERT0_R_ZTSNSt9enable_ifIXntsr14is_simple_typeIT0_EE5valueEN4llvm10cast_rettyIT_S0_E8ret_typeEE4typeE;Tpl__ZN4llvm16dyn_cast_or_nullEPT0_;Tpl__ZN4llvm16dyn_cast_or_nullERKT0_R_ZTSNSt9enable_ifIXntsr14is_simple_typeIT0_EE5valueEN4llvm10cast_rettyIT_KS0_E8ret_typeEE4typeE;Tpl__ZN4llvm16dyn_cast_or_nullERT0_R_ZTSNSt9enable_ifIXntsr14is_simple_typeIT0_EE5valueEN4llvm10cast_rettyIT_S0_E8ret_typeEE4typeE;Tpl__ZN4llvm3isaERKT0_;Tpl__ZN4llvm4castEPT0_;Tpl__ZN4llvm4castERKT0_R_ZTSNSt9enable_ifIXntsr14is_simple_typeIT0_EE5valueEN4llvm10cast_rettyIT_KS0_E8ret_typeEE4typeE;Tpl__ZN4llvm4castERT0_;Tpl__ZN4llvm8dyn_castEPT0_;Tpl__ZN4llvm8dyn_castERKT0_R_ZTSNSt9enable_ifIXntsr14is_simple_typeIT0_EE5valueEN4llvm10cast_rettyIT_KS0_E8ret_typeEE4typeE;Tpl__ZN4llvm8dyn_castERT0_; -static-type=CastingLlvmGlobals -package=org.llvm.support.impl")
//</editor-fold>
public final class CastingLlvmGlobals {
  
//===----------------------------------------------------------------------===//
// LLVM-style downcasting support for IntrusiveRefCntPtr objects
//===----------------------------------------------------------------------===//
//
//  template<class T> struct simplify_type<IntrusiveRefCntPtr<T> > {
//    typedef T* SimpleType;
//    static SimpleType getSimplifiedValue(IntrusiveRefCntPtr<T>& Val) {
//      return Val.get();
//    }
//  };
//
//  template<class T> struct simplify_type<const IntrusiveRefCntPtr<T> > {
//    typedef /*const*/ T* SimpleType;
//    static SimpleType getSimplifiedValue(const IntrusiveRefCntPtr<T>& Val) {
//      return Val.get();
//    }
//  };
  
private static final List<simplify_type> simplifiers = new ArrayList<>();

static {
  initSimplifiers();
}

private static void initSimplifiers() {
//  loadSimplifier("org.llvm.adt.simplify_typeIntrusiveRefCntPtr");
//  loadSimplifier("org.clang.ast.llvm.simplify_typeCanQual$T");
}

private static void loadSimplifier(String qualName) {
  // simplify_typeIntrusiveRefCntPtr
  try {
    Class<? extends simplify_type> cls = (Class<? extends simplify_type>) Class.forName(qualName, true, Thread.currentThread().getContextClassLoader());
    simplifiers.add(cls.newInstance());
  } catch (ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
    NativeTrace.printStackTraceOnce(ex);
    llvm.errs().$out(ex.getClass().getName()).$out(' ').$out(ex.getMessage()).$out("\n");
  }
}
  
@Converted(kind = Converted.Kind.MANUAL_ADDED)
public static <T> T getSimplifiedValue(Object Val) {
  if (Val instanceof simplify_type) {
    return getSimplifiedValue((simplify_type)Val);
  } 
//  // TODO: replace all simplifiers with isntanceof's (like above).
//  for (simplify_type simplifier : simplifiers) {
//    Object simplified = simplifier.getSimplifiedValue(Val);
//    if (simplified != Val) {
//      return (T) simplified;
//    }
//  }
  return (T) Val;         
}

@Converted(kind = Converted.Kind.MANUAL_ADDED)
public static <T> T getSimplifiedValue(simplify_type Val) {
  return (T) ((simplify_type)Val).getSimplifiedValue(Val);
}

// isa<X> - Return true if the parameter to the template is an instance of the
// template type argument.  Used like this:
//
//  if (isa<Type>(myVal)) { ... }
//
/*template <class X, class Y> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::isa">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", line = 132,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", old_line = 131,
 FQN="llvm::isa", NM="Tpl__ZN4llvm3isaERKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=Tpl__ZN4llvm3isaERKT0_")
//</editor-fold>
public static /*inline*/ </*class*/ X, /*class*/ Y> boolean isa(Class<X> cls, /*const*/ Y /*&*/ Val)/* __attribute__((warn_unused_result))*/ {
  //return isa_impl_wrap<X, /*const*/ Y,  simplify_type</*const*/ Y>.SimpleType>.doit(Val);
  return cls.isInstance(getSimplifiedValue(Val));
}
public static /*inline*/ </*class*/ X, /*class*/ Y extends simplify_type> boolean isa(Class<X> cls, /*const*/ Y /*&*/ Val)/* __attribute__((warn_unused_result))*/ {
  //return isa_impl_wrap<X, /*const*/ Y,  simplify_type</*const*/ Y>.SimpleType>.doit(Val);
  return cls.isInstance(getSimplifiedValue(Val));
}


// cast<X> - Return the argument parameter cast to the specified type.  This
// casting operator asserts that the type is correct, so it does not return null
// on failure.  It does not allow a null argument (use cast_or_null for that).
// It is typically used like this:
//
//  cast<Instruction>(myVal)->getParent()
//
/*template <class X, class Y> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::cast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", line = 220,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", old_line = 219,
 FQN="llvm::cast", NM="Tpl__ZN4llvm4castERKT0_R_ZTSNSt9enable_ifIXntsr14is_simple_typeIT0_EE5valueEN4llvm10cast_rettyIT_KS0_E8ret_typeEE4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=Tpl__ZN4llvm4castERKT0_R_ZTSNSt9enable_ifIXntsr14is_simple_typeIT0_EE5valueEN4llvm10cast_rettyIT_KS0_E8ret_typeEE4typeE")
//</editor-fold>
public static /*inline*/ </*class*/ X, /*class*/ Y extends simplify_type> /*std::enable_if<!is_simple_type<Y>::value,  cast_retty<X,  Y>.ret_type>::type*/ X cast$NotSimpleType(Class<X> clsX, /*const*/ Y /*&*/ Val) {
  assert (isa(clsX, Val)) : "cast<Ty>() argument of incompatible type!";
//  return cast_convert_val<X, /*const*/ Y,  simplify_type</*const*/ Y>.SimpleType>.doit(Val);
  return clsX.cast(getSimplifiedValue(Val));
}

/*template <class X, class Y> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::cast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", line = 229,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", old_line = 228,
 FQN="llvm::cast", NM="Tpl__ZN4llvm4castERT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=Tpl__ZN4llvm4castERT0_")
//</editor-fold>
public static /*inline*/ </*class*/ X, /*class*/ Y>  X cast(Class<X> clsX, Y /*&*/ Val) {
  assert (isa(clsX, Val)) : "cast<Ty>() argument of incompatible type!";
  //return cast_convert_val<X, Y,  simplify_type<Y>.SimpleType>.doit(Val);
  return clsX.cast(getSimplifiedValue(Val));
}
public static /*inline*/ </*class*/ X, /*class*/ Y extends simplify_type>  X cast(Class<X> clsX, Y /*&*/ Val) {
  assert (isa(clsX, Val)) : "cast<Ty>() argument of incompatible type!";
  //return cast_convert_val<X, Y,  simplify_type<Y>.SimpleType>.doit(Val);
  return clsX.cast(getSimplifiedValue(Val));
}

/*template <class X, class Y> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::cast">
//@Converted(kind = Converted.Kind.AUTO,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", line = 236,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", old_line = 235,
// FQN="llvm::cast", NM="Tpl__ZN4llvm4castEPT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=Tpl__ZN4llvm4castEPT0_")
////</editor-fold>
//public static /*inline*/ </*class*/ X, /*class*/ Y>  cast_retty<X, Y /*P*/ >.ret_type cast(Y /*P*/ Val) {
//  assert (isa<X>(Val)) : "cast<Ty>() argument of incompatible type!";
//  return cast_convert_val<X, Y /*P*/ ,  simplify_type<Y /*P*/ >.SimpleType>.doit(Val);
//}


// cast_or_null<X> - Functionally identical to cast, except that a null value is
// accepted.
//
/*template <class X, class Y> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::cast_or_null">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", line = 246,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", old_line = 245,
 FQN="llvm::cast_or_null", NM="Tpl__ZN4llvm12cast_or_nullERKT0_R_ZTSNSt9enable_ifIXntsr14is_simple_typeIT0_EE5valueEN4llvm10cast_rettyIT_KS0_E8ret_typeEE4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=Tpl__ZN4llvm12cast_or_nullERKT0_R_ZTSNSt9enable_ifIXntsr14is_simple_typeIT0_EE5valueEN4llvm10cast_rettyIT_KS0_E8ret_typeEE4typeE")
//</editor-fold>
public static /*inline*/ </*class*/ X, /*class*/ Y extends simplify_type> /*std::enable_if<!is_simple_type<Y>::value,  cast_retty<X,  Y>.ret_type>::type*/ X cast_or_null$NotSimpleType(Class<X> clsX, /*const*/ Y /*&*/ Val)/* __attribute__((warn_unused_result))*/ {
  if (getSimplifiedValue(Val) == null) {
    return null;
  }
  assert (isa(clsX, Val)) : "cast_or_null<Ty>() argument of incompatible type!";
  return cast(clsX, Val);
}

/*template <class X, class Y> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::cast_or_null">
//@Converted(kind = Converted.Kind.AUTO,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", line = 256,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", old_line = 255,
// FQN="llvm::cast_or_null", NM="Tpl__ZN4llvm12cast_or_nullERT0_R_ZTSNSt9enable_ifIXntsr14is_simple_typeIT0_EE5valueEN4llvm10cast_rettyIT_S0_E8ret_typeEE4typeE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=Tpl__ZN4llvm12cast_or_nullERT0_R_ZTSNSt9enable_ifIXntsr14is_simple_typeIT0_EE5valueEN4llvm10cast_rettyIT_S0_E8ret_typeEE4typeE")
//////</editor-fold>
//public static /*inline*/ </*class*/ X, /*class*/ Y> /*std::enable_if<!is_simple_type<Y>::value,  cast_retty<X, Y>.ret_type>::type*/ cast_retty<X, Y>.ret_type cast_or_null$NotSimpleType(Y /*&*/ Val)/* __attribute__((warn_unused_result))*/ {
//  if (Val == null) {
//    return null;
//  }
//  assert (isa<X>(Val)) : "cast_or_null<Ty>() argument of incompatible type!";
//  return cast<X>(Val);
//}

/*template <class X, class Y> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::cast_or_null">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", line = 266,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", old_line = 265,
 FQN="llvm::cast_or_null", NM="Tpl__ZN4llvm12cast_or_nullEPT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=Tpl__ZN4llvm12cast_or_nullEPT0_")
//</editor-fold>
public static /*inline*/ </*class*/ X, /*class*/ Y>  X cast_or_null(Class<X> clsX, Y /*P*/ Val)/* __attribute__((warn_unused_result))*/ {
  if (getSimplifiedValue(Val) == null) {
    return null;
  }
  assert (isa(clsX, Val)) : "cast_or_null<Ty>() argument of incompatible type!";
  return cast(clsX, Val);
}
public static /*inline*/ </*class*/ X, /*class*/ Y extends simplify_type>  X cast_or_null(Class<X> clsX, Y /*P*/ Val)/* __attribute__((warn_unused_result))*/ {
  if (getSimplifiedValue(Val) == null) {
    return null;
  }
  assert (isa(clsX, Val)) : "cast_or_null<Ty>() argument of incompatible type!";
  return cast(clsX, Val);
}


// dyn_cast<X> - Return the argument parameter cast to the specified type.  This
// casting operator returns null if the argument is of the wrong type, so it can
// be used to test for a type as well as cast if successful.  This should be
// used in the context of an if statement like this:
//
//  if (const Instruction *I = dyn_cast<Instruction>(myVal)) { ... }
//
/*template <class X, class Y> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::dyn_cast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", line = 283,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", old_line = 282,
 FQN="llvm::dyn_cast", NM="Tpl__ZN4llvm8dyn_castERKT0_R_ZTSNSt9enable_ifIXntsr14is_simple_typeIT0_EE5valueEN4llvm10cast_rettyIT_KS0_E8ret_typeEE4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=Tpl__ZN4llvm8dyn_castERKT0_R_ZTSNSt9enable_ifIXntsr14is_simple_typeIT0_EE5valueEN4llvm10cast_rettyIT_KS0_E8ret_typeEE4typeE")
//</editor-fold>
public static /*inline*/ </*class*/ X, /*class*/ Y extends simplify_type> /*std::enable_if<!is_simple_type<Y>::value,  cast_retty<X,  Y>.ret_type>::type*/ X dyn_cast$NotSimpleType(Class<X> clsX, /*const*/ Y /*&*/ Val)/* __attribute__((warn_unused_result))*/ {
  return isa(clsX, Val) ? cast(clsX, Val) : null;
}

/*template <class X, class Y> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::dyn_cast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", line = 290,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", old_line = 289,
 FQN="llvm::dyn_cast", NM="Tpl__ZN4llvm8dyn_castERT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=Tpl__ZN4llvm8dyn_castERT0_")
//</editor-fold>
public static /*inline*/ </*class*/ X, /*class*/ Y>  X dyn_cast(Class<X> clsX, Y /*&*/ Val)/* __attribute__((warn_unused_result))*/ {
  return isa(clsX, Val) ? cast(clsX, Val) : null;
}
public static /*inline*/ </*class*/ X, /*class*/ Y extends simplify_type>  X dyn_cast(Class<X> clsX, Y /*&*/ Val)/* __attribute__((warn_unused_result))*/ {
  return isa(clsX, Val) ? cast(clsX, Val) : null;
}

/*template <class X, class Y> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::dyn_cast">
//@Converted(kind = Converted.Kind.AUTO,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", line = 296,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", old_line = 295,
// FQN="llvm::dyn_cast", NM="Tpl__ZN4llvm8dyn_castEPT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=Tpl__ZN4llvm8dyn_castEPT0_")
////</editor-fold>
//public static /*inline*/ </*class*/ X, /*class*/ Y>  cast_retty<X, Y /*P*/ >.ret_type dyn_cast(Y /*P*/ Val)/* __attribute__((warn_unused_result))*/ {
//  return isa<X>(Val) ? cast<X>(Val) : null;
//}


// dyn_cast_or_null<X> - Functionally identical to dyn_cast, except that a null
// value is accepted.
//
/*template <class X, class Y> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::dyn_cast_or_null">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", line = 305,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", old_line = 304,
 FQN="llvm::dyn_cast_or_null", NM="Tpl__ZN4llvm16dyn_cast_or_nullERKT0_R_ZTSNSt9enable_ifIXntsr14is_simple_typeIT0_EE5valueEN4llvm10cast_rettyIT_KS0_E8ret_typeEE4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=Tpl__ZN4llvm16dyn_cast_or_nullERKT0_R_ZTSNSt9enable_ifIXntsr14is_simple_typeIT0_EE5valueEN4llvm10cast_rettyIT_KS0_E8ret_typeEE4typeE")
//</editor-fold>
public static /*inline*/ </*class*/ X, /*class*/ Y extends simplify_type> /*std::enable_if<!is_simple_type<Y>::value,  cast_retty<X,  Y>.ret_type>::type*/ X dyn_cast_or_null$NotSimpleType(Class<X> clsX, /*const*/ Y /*&*/ Val)/* __attribute__((warn_unused_result))*/ {
  return (Val != null && isa(clsX, Val)) ? cast(clsX, Val) : null;
}

/*template <class X, class Y> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::dyn_cast_or_null">
//@Converted(kind = Converted.Kind.AUTO,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", line = 312,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", old_line = 311,
// FQN="llvm::dyn_cast_or_null", NM="Tpl__ZN4llvm16dyn_cast_or_nullERT0_R_ZTSNSt9enable_ifIXntsr14is_simple_typeIT0_EE5valueEN4llvm10cast_rettyIT_S0_E8ret_typeEE4typeE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=Tpl__ZN4llvm16dyn_cast_or_nullERT0_R_ZTSNSt9enable_ifIXntsr14is_simple_typeIT0_EE5valueEN4llvm10cast_rettyIT_S0_E8ret_typeEE4typeE")
////</editor-fold>
//public static /*inline*/ </*class*/ X, /*class*/ Y> /*std::enable_if<!is_simple_type<Y>::value,  cast_retty<X, Y>.ret_type>::type*/ cast_retty<X, Y>.ret_type dyn_cast_or_null$NotSimpleType(Y /*&*/ Val)/* __attribute__((warn_unused_result))*/ {
//  return (Val && isa<X>(Val)) ? cast<X>(Val) : null;
//}

/*template <class X, class Y> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::dyn_cast_or_null">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", line = 319,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", old_line = 318,
 FQN="llvm::dyn_cast_or_null", NM="Tpl__ZN4llvm16dyn_cast_or_nullEPT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=Tpl__ZN4llvm16dyn_cast_or_nullEPT0_")
//</editor-fold>
public static /*inline*/ </*class*/ X, /*class*/ Y>  X dyn_cast_or_null(Class<X> clsX, Y /*P*/ Val)/* __attribute__((warn_unused_result))*/ {
  return (Val != null && isa(clsX, Val)) ? cast(clsX, Val) : null;
}
public static /*inline*/ </*class*/ X, /*class*/ Y extends simplify_type>  X dyn_cast_or_null(Class<X> clsX, Y /*P*/ Val)/* __attribute__((warn_unused_result))*/ {
  return (Val != null && isa(clsX, Val)) ? cast(clsX, Val) : null;
}

} // END OF class CastingLlvmGlobals
