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
package org.clang.sema;

import org.clank.support.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;


//<editor-fold defaultstate="collapsed" desc="static type AttrParsedAttrKindsGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZL11getAttrKindN4llvm9StringRefEN5clang13AttributeList6SyntaxE; -static-type=AttrParsedAttrKindsGlobals -package=org.clang.sema")
//</editor-fold>
public final class AttrParsedAttrKindsGlobals {

/*===- TableGen'erated file -------------------------------------*- C++ -*-===*\
|*                                                                            *|
|* Attribute name matcher                                                     *|
|*                                                                            *|
|* Automatically generated file, do not edit!                                 *|
|*                                                                            *|
\*===----------------------------------------------------------------------===*/
//<editor-fold defaultstate="collapsed" desc="getAttrKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrKinds.inc", line = 9,
 FQN="getAttrKind", NM="_ZL11getAttrKindN4llvm9StringRefEN5clang13AttributeList6SyntaxE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZL11getAttrKindN4llvm9StringRefEN5clang13AttributeList6SyntaxE")
//</editor-fold>
public static AttributeList.Kind getAttrKind(StringRef Name, AttributeList.Syntax Syntax) {
  if (AttributeList.Syntax.AS_GNU == Syntax) {
    switch (Name.size()) {
     default:
      break;
     case 3: // 2 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case 'h': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("ot"), 2) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_Hot; // "hot"
       case 'p': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("cs"), 2) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_Pcs; // "pcs"
      }
      break;
     case 4: // 6 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case 'c': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("old"), 3) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_Cold; // "cold"
       case 'h': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("ost"), 3) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_CUDAHost; // "host"
       case 'm': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("ode"), 3) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_Mode; // "mode"
       case 'p': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("ure"), 3) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_Pure; // "pure"
       case 'u': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("sed"), 3) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_Used; // "used"
       case 'w': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("eak"), 3) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_Weak; // "weak"
      }
      break;
     case 5: // 6 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case 'a': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("lias"), 4) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_Alias; // "alias"
       case 'c': // 2 strings to match.
        switch (Name.$at(1)) {
         default:
          break;
         case 'd': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("ecl"), 3) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_CDecl; // "cdecl"
         case 'o': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("nst"), 3) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_Const; // "const"
        }
        break;
       case 'i': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("func"), 4) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_IFunc; // "ifunc"
       case 'n': // 2 strings to match.
        switch (Name.$at(1)) {
         default:
          break;
         case 'a': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("ked"), 3) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_Naked; // "naked"
         case 'o': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("svm"), 3) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_OpenCLNoSVM; // "nosvm"
        }
        break;
      }
      break;
     case 6: // 14 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case 'b': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("locks"), 5) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_Blocks; // "blocks"
       case 'c': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("ommon"), 5) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_Common; // "common"
       case 'd': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("evice"), 5) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_CUDADevice; // "device"
       case 'f': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("ormat"), 5) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_Format; // "format"
       case 'g': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("lobal"), 5) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_CUDAGlobal; // "global"
       case 'k': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("ernel"), 5) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_RenderScriptKernel; // "kernel"
       case 'm': // 3 strings to match.
        switch (Name.$at(1)) {
         default:
          break;
         case 'a': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("lloc"), 4) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_Restrict; // "malloc"
         case 'i': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("ps16"), 4) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_Mips16; // "mips16"
         case 's': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("_abi"), 4) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_MSABI; // "ms_abi"
        }
        break;
       case 'p': // 2 strings to match.
        if (Name.$at(1) != $$a) {
          break;
        }
        switch (Name.$at(2)) {
         default:
          break;
         case 'c': // 1 string to match.
          if ((memcmp(Name.data().$add(3), $("ked"), 3) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_Packed; // "packed"
         case 's': // 1 string to match.
          if ((memcmp(Name.data().$add(3), $("cal"), 3) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_Pascal; // "pascal"
        }
        break;
       case 's': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("hared"), 5) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_CUDAShared; // "shared"
       case 't': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("arget"), 5) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_Target; // "target"
       case 'u': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("nused"), 5) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_Unused; // "unused"
      }
      break;
     case 7: // 17 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case '_': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("_const"), 6) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_Const; // "__const"
       case 'a': // 2 strings to match.
        switch (Name.$at(1)) {
         default:
          break;
         case 'b': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("i_tag"), 5) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_AbiTag; // "abi_tag"
         case 'l': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("igned"), 5) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_Aligned; // "aligned"
        }
        break;
       case 'b': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("ounded"), 6) != 0)) {
          break;
        }
        return AttributeList.Kind.IgnoredAttribute; // "bounded"
       case 'c': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("leanup"), 6) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_Cleanup; // "cleanup"
       case 'f': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("latten"), 6) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_Flatten; // "flatten"
       case 'm': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("insize"), 6) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_MinSize; // "minsize"
       case 'n': // 4 strings to match.
        switch (Name.$at(1)) {
         default:
          break;
         case 'o': // 3 strings to match.
          switch (Name.$at(2)) {
           default:
            break;
           case 'd': // 1 string to match.
            if ((memcmp(Name.data().$add(3), $("ebug"), 4) != 0)) {
              break;
            }
            return AttributeList.Kind.AT_NoDebug; // "nodebug"
           case 'n': // 1 string to match.
            if ((memcmp(Name.data().$add(3), $("null"), 4) != 0)) {
              break;
            }
            return AttributeList.Kind.AT_NonNull; // "nonnull"
           case 't': // 1 string to match.
            if ((memcmp(Name.data().$add(3), $("hrow"), 4) != 0)) {
              break;
            }
            return AttributeList.Kind.AT_NoThrow; // "nothrow"
          }
          break;
         case 'v': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("_weak"), 5) != 0)) {
            break;
          }
          return AttributeList.Kind.IgnoredAttribute; // "nv_weak"
        }
        break;
       case 'o': // 2 strings to match.
        switch (Name.$at(1)) {
         default:
          break;
         case 'b': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("jc_gc"), 5) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_ObjCGC; // "objc_gc"
         case 'p': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("tnone"), 5) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_OptimizeNone; // "optnone"
        }
        break;
       case 'r': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("egparm"), 6) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_Regparm; // "regparm"
       case 's': // 2 strings to match.
        switch (Name.$at(1)) {
         default:
          break;
         case 'e': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("ction"), 5) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_Section; // "section"
         case 't': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("dcall"), 5) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_StdCall; // "stdcall"
        }
        break;
       case 'w': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("eakref"), 6) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_WeakRef; // "weakref"
      }
      break;
     case 8: // 14 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case 'N': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("SObject"), 7) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_ObjCNSObject; // "NSObject"
       case 'a': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("nnotate"), 7) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_Annotate; // "annotate"
       case 'c': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("onstant"), 7) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_CUDAConstant; // "constant"
       case 'f': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("astcall"), 7) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_FastCall; // "fastcall"
       case 'i': // 2 strings to match.
        if (Name.$at(1) != $$b) {
          break;
        }
        switch (Name.$at(2)) {
         default:
          break;
         case 'a': // 1 string to match.
          if ((memcmp(Name.data().$add(3), $("ction"), 5) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_IBAction; // "ibaction"
         case 'o': // 1 string to match.
          if ((memcmp(Name.data().$add(3), $("utlet"), 5) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_IBOutlet; // "iboutlet"
        }
        break;
       case 'l': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("ockable"), 7) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_Lockable; // "lockable"
       case 'n': // 4 strings to match.
        if (Name.$at(1) != $$o) {
          break;
        }
        switch (Name.$at(2)) {
         default:
          break;
         case 'c': // 1 string to match.
          if ((memcmp(Name.data().$add(3), $("ommon"), 5) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_NoCommon; // "nocommon"
         case 'i': // 1 string to match.
          if ((memcmp(Name.data().$add(3), $("nline"), 5) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_NoInline; // "noinline"
         case 'm': // 1 string to match.
          if ((memcmp(Name.data().$add(3), $("ips16"), 5) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_NoMips16; // "nomips16"
         case 'r': // 1 string to match.
          if ((memcmp(Name.data().$add(3), $("eturn"), 5) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_NoReturn; // "noreturn"
        }
        break;
       case 's': // 2 strings to match.
        switch (Name.$at(1)) {
         default:
          break;
         case 'e': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("ntinel"), 6) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_Sentinel; // "sentinel"
         case 'y': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("sv_abi"), 6) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_SysVABI; // "sysv_abi"
        }
        break;
       case 't': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("hiscall"), 7) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_ThisCall; // "thiscall"
      }
      break;
     case 9: // 10 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case 'd': // 2 strings to match.
        if ((memcmp(Name.data().$add(1), $ll, 2) != 0)) {
          break;
        }
        switch (Name.$at(3)) {
         default:
          break;
         case 'e': // 1 string to match.
          if ((memcmp(Name.data().$add(4), $("xport"), 5) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_DLLExport; // "dllexport"
         case 'i': // 1 string to match.
          if ((memcmp(Name.data().$add(4), $("mport"), 5) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_DLLImport; // "dllimport"
        }
        break;
       case 'e': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("nable_if"), 8) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_EnableIf; // "enable_if"
       case 'f': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("lag_enum"), 8) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_FlagEnum; // "flag_enum"
       case 'i': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("nterrupt"), 8) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_Interrupt; // "interrupt"
       case 'm': // 2 strings to match.
        switch (Name.$at(1)) {
         default:
          break;
         case 'a': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("y_alias"), 7) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_MayAlias; // "may_alias"
         case 's': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("_struct"), 7) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_MSStruct; // "ms_struct"
        }
        break;
       case 's': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("wiftcall"), 8) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_SwiftCall; // "swiftcall"
       case 't': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("ls_model"), 8) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_TLSModel; // "tls_model"
       case 'v': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("ecreturn"), 8) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_VecReturn; // "vecreturn"
      }
      break;
     case 10: // 9 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case 'c': // 2 strings to match.
        switch (Name.$at(1)) {
         default:
          break;
         case 'a': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("pability"), 8) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_Capability; // "capability"
         case 'o': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("nsumable"), 8) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_Consumable; // "consumable"
        }
        break;
       case 'd': // 2 strings to match.
        if (Name.$at(1) != $$e) {
          break;
        }
        switch (Name.$at(2)) {
         default:
          break;
         case 'p': // 1 string to match.
          if ((memcmp(Name.data().$add(3), $("recated"), 7) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_Deprecated; // "deprecated"
         case 's': // 1 string to match.
          if ((memcmp(Name.data().$add(3), $("tructor"), 7) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_Destructor; // "destructor"
        }
        break;
       case 'f': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("ormat_arg"), 9) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_FormatArg; // "format_arg"
       case 'g': // 2 strings to match.
        switch (Name.$at(1)) {
         default:
          break;
         case 'n': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("u_inline"), 8) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_GNUInline; // "gnu_inline"
         case 'u': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("arded_by"), 8) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_GuardedBy; // "guarded_by"
        }
        break;
       case 'v': // 2 strings to match.
        switch (Name.$at(1)) {
         default:
          break;
         case 'e': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("ctorcall"), 8) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_VectorCall; // "vectorcall"
         case 'i': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("sibility"), 8) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_Visibility; // "visibility"
        }
        break;
      }
      break;
     case 11: // 12 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case 'a': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("lign_value"), 10) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_AlignValue; // "align_value"
       case 'c': // 2 strings to match.
        switch (Name.$at(1)) {
         default:
          break;
         case 'f': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("_consumed"), 9) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_CFConsumed; // "cf_consumed"
         case 'o': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("nstructor"), 9) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_Constructor; // "constructor"
        }
        break;
       case 'g': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("uarded_var"), 10) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_GuardedVar; // "guarded_var"
       case 'n': // 3 strings to match.
        switch (Name.$at(1)) {
         default:
          break;
         case 'o': // 2 strings to match.
          switch (Name.$at(2)) {
           default:
            break;
           case '_': // 1 string to match.
            if ((memcmp(Name.data().$add(3), $("sanitize"), 8) != 0)) {
              break;
            }
            return AttributeList.Kind.AT_NoSanitize; // "no_sanitize"
           case 'd': // 1 string to match.
            if ((memcmp(Name.data().$add(3), $("uplicate"), 8) != 0)) {
              break;
            }
            return AttributeList.Kind.AT_NoDuplicate; // "noduplicate"
          }
          break;
         case 's': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("_consumed"), 9) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_NSConsumed; // "ns_consumed"
        }
        break;
       case 'o': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("bjc_bridge"), 10) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_ObjCBridge; // "objc_bridge"
       case 'u': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("navailable"), 10) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_Unavailable; // "unavailable"
       case 'v': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("ector_size"), 10) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_VectorSize; // "vector_size"
       case 'w': // 2 strings to match.
        switch (Name.$at(1)) {
         default:
          break;
         case 'a': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("rn_unused"), 9) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_WarnUnused; // "warn_unused"
         case 'e': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("ak_import"), 9) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_WeakImport; // "weak_import"
        }
        break;
      }
      break;
     case 12: // 4 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case 'a': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("vailability"), 11) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_Availability; // "availability"
       case 'o': // 2 strings to match.
        switch (Name.$at(1)) {
         default:
          break;
         case 'b': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("jc_boxable"), 10) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_ObjCBoxable; // "objc_boxable"
         case 'v': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("erloadable"), 10) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_Overloadable; // "overloadable"
        }
        break;
       case 'p': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("reserve_all"), 11) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_PreserveAll; // "preserve_all"
      }
      break;
     case 13: // 12 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case 'a': // 2 strings to match.
        switch (Name.$at(1)) {
         default:
          break;
         case 'd': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("dress_space"), 11) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_AddressSpace; // "address_space"
         case 'l': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("ways_inline"), 11) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_AlwaysInline; // "always_inline"
        }
        break;
       case 'c': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("allable_when"), 12) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_CallableWhen; // "callable_when"
       case 'i': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("nit_priority"), 12) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_InitPriority; // "init_priority"
       case 'l': // 2 strings to match.
        switch (Name.$at(1)) {
         default:
          break;
         case 'a': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("unch_bounds"), 11) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_CUDALaunchBounds; // "launch_bounds"
         case 'o': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("ck_returned"), 11) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_LockReturned; // "lock_returned"
        }
        break;
       case 'p': // 2 strings to match.
        switch (Name.$at(1)) {
         default:
          break;
         case 'r': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("eserve_most"), 11) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_PreserveMost; // "preserve_most"
         case 't': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("_guarded_by"), 11) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_PtGuardedBy; // "pt_guarded_by"
        }
        break;
       case 'r': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("eturns_twice"), 12) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_ReturnsTwice; // "returns_twice"
       case 's': // 2 strings to match.
        switch (Name.$at(1)) {
         default:
          break;
         case 'e': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("t_typestate"), 11) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_SetTypestate; // "set_typestate"
         case 'w': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("ift_context"), 11) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_SwiftContext; // "swift_context"
        }
        break;
       case 'v': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("ec_type_hint"), 12) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_VecTypeHint; // "vec_type_hint"
      }
      break;
     case 14: // 11 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case 'a': // 2 strings to match.
        switch (Name.$at(1)) {
         default:
          break;
         case 'c': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("quired_after"), 12) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_AcquiredAfter; // "acquired_after"
         case 's': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("sume_aligned"), 12) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_AssumeAligned; // "assume_aligned"
        }
        break;
       case 'c': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("udart_builtin"), 13) != 0)) {
          break;
        }
        return AttributeList.Kind.IgnoredAttribute; // "cudart_builtin"
       case 'd': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("evice_builtin"), 13) != 0)) {
          break;
        }
        return AttributeList.Kind.IgnoredAttribute; // "device_builtin"
       case 'i': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("ntel_ocl_bicc"), 13) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_IntelOclBicc; // "intel_ocl_bicc"
       case 'l': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("ocks_excluded"), 13) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_LocksExcluded; // "locks_excluded"
       case 'n': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("o_split_stack"), 13) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_NoSplitStack; // "no_split_stack"
       case 'o': // 2 strings to match.
        if ((memcmp(Name.data().$add(1), $("bjc_"), 4) != 0)) {
          break;
        }
        switch (Name.$at(5)) {
         default:
          break;
         case 'e': // 1 string to match.
          if ((memcmp(Name.data().$add(6), $("xception"), 8) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_ObjCException; // "objc_exception"
         case 'o': // 1 string to match.
          if ((memcmp(Name.data().$add(6), $("wnership"), 8) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_ObjCOwnership; // "objc_ownership"
        }
        break;
       case 'p': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("t_guarded_var"), 13) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_PtGuardedVar; // "pt_guarded_var"
       case 't': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("est_typestate"), 13) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_TestTypestate; // "test_typestate"
      }
      break;
     case 15: // 13 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case 'a': // 3 strings to match.
        switch (Name.$at(1)) {
         default:
          break;
         case 'c': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("quired_before"), 13) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_AcquiredBefore; // "acquired_before"
         case 'm': // 2 strings to match.
          if ((memcmp(Name.data().$add(2), $("dgpu_num_"), 9) != 0)) {
            break;
          }
          switch (Name.$at(11)) {
           default:
            break;
           case 's': // 1 string to match.
            if ((memcmp(Name.data().$add(12), $("gpr"), 3) != 0)) {
              break;
            }
            return AttributeList.Kind.AT_AMDGPUNumSGPR; // "amdgpu_num_sgpr"
           case 'v': // 1 string to match.
            if ((memcmp(Name.data().$add(12), $("gpr"), 3) != 0)) {
              break;
            }
            return AttributeList.Kind.AT_AMDGPUNumVGPR; // "amdgpu_num_vgpr"
          }
          break;
        }
        break;
       case 'e': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("xt_vector_type"), 14) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_ExtVectorType; // "ext_vector_type"
       case 'n': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("ot_tail_called"), 14) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_NotTailCalled; // "not_tail_called"
       case 'o': // 3 strings to match.
        switch (Name.$at(1)) {
         default:
          break;
         case 'b': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("jc_root_class"), 13) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_ObjCRootClass; // "objc_root_class"
         case 'w': // 2 strings to match.
          if ((memcmp(Name.data().$add(2), $("nership_"), 8) != 0)) {
            break;
          }
          switch (Name.$at(10)) {
           default:
            break;
           case 'h': // 1 string to match.
            if ((memcmp(Name.data().$add(11), $("olds"), 4) != 0)) {
              break;
            }
            return AttributeList.Kind.AT_Ownership; // "ownership_holds"
           case 't': // 1 string to match.
            if ((memcmp(Name.data().$add(11), $("akes"), 4) != 0)) {
              break;
            }
            return AttributeList.Kind.AT_Ownership; // "ownership_takes"
          }
          break;
        }
        break;
       case 'p': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("aram_typestate"), 14) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_ParamTypestate; // "param_typestate"
       case 'r': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("eturns_nonnull"), 14) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_ReturnsNonNull; // "returns_nonnull"
       case 's': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("coped_lockable"), 14) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_ScopedLockable; // "scoped_lockable"
       case 't': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("ype_visibility"), 14) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_TypeVisibility; // "type_visibility"
       case 'u': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("nlock_function"), 14) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_ReleaseCapability; // "unlock_function"
      }
      break;
     case 16: // 5 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case 'i': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("nternal_linkage"), 15) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_InternalLinkage; // "internal_linkage"
       case 'n': // 2 strings to match.
        switch (Name.$at(1)) {
         default:
          break;
         case 'e': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("on_vector_type"), 14) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_NeonVectorType; // "neon_vector_type"
         case 's': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("_consumes_self"), 14) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_NSConsumesSelf; // "ns_consumes_self"
        }
        break;
       case 'p': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("ass_object_size"), 15) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_PassObjectSize; // "pass_object_size"
       case 'r': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("eturn_typestate"), 15) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_ReturnTypestate; // "return_typestate"
      }
      break;
     case 17: // 6 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case 'a': // 2 strings to match.
        switch (Name.$at(1)) {
         default:
          break;
         case 'n': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("alyzer_noreturn"), 15) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_AnalyzerNoReturn; // "analyzer_noreturn"
         case 's': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("sert_capability"), 15) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_AssertCapability; // "assert_capability"
        }
        break;
       case 'o': // 2 strings to match.
        switch (Name.$at(1)) {
         default:
          break;
         case 'b': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("jc_runtime_name"), 15) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_ObjCRuntimeName; // "objc_runtime_name"
         case 'w': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("nership_returns"), 15) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_Ownership; // "ownership_returns"
        }
        break;
       case 's': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("hared_capability"), 16) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_Capability; // "shared_capability"
       case 't': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("ransparent_union"), 16) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_TransparentUnion; // "transparent_union"
      }
      break;
     case 18: // 12 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case 'a': // 2 strings to match.
        switch (Name.$at(1)) {
         default:
          break;
         case 'c': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("quire_capability"), 16) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_AcquireCapability; // "acquire_capability"
         case 's': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("sert_shared_lock"), 16) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_AssertSharedLock; // "assert_shared_lock"
        }
        break;
       case 'c': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("arries_dependency"), 17) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_CarriesDependency; // "carries_dependency"
       case 'd': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("isable_tail_calls"), 17) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_DisableTailCalls; // "disable_tail_calls"
       case 'i': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("boutletcollection"), 17) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_IBOutletCollection; // "iboutletcollection"
       case 'n': // 2 strings to match.
        if ((memcmp(Name.data().$add(1), $("o_sanitize_"), 11) != 0)) {
          break;
        }
        switch (Name.$at(12)) {
         default:
          break;
         case 'm': // 1 string to match.
          if ((memcmp(Name.data().$add(13), $("emory"), 5) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_NoSanitizeSpecific; // "no_sanitize_memory"
         case 't': // 1 string to match.
          if ((memcmp(Name.data().$add(13), $("hread"), 5) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_NoSanitizeSpecific; // "no_sanitize_thread"
        }
        break;
       case 'o': // 2 strings to match.
        switch (Name.$at(1)) {
         default:
          break;
         case 'b': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("jc_method_family"), 16) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_ObjCMethodFamily; // "objc_method_family"
         case 'p': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("encl_unroll_hint"), 16) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_OpenCLUnrollHint; // "opencl_unroll_hint"
        }
        break;
       case 'r': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("elease_capability"), 17) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_ReleaseCapability; // "release_capability"
       case 's': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("wift_error_result"), 17) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_SwiftErrorResult; // "swift_error_result"
       case 'w': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("arn_unused_result"), 17) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_WarnUnusedResult; // "warn_unused_result"
      }
      break;
     case 19: // 9 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case 'c': // 3 strings to match.
        if ((memcmp(Name.data().$add(1), $("f_"), 2) != 0)) {
          break;
        }
        switch (Name.$at(3)) {
         default:
          break;
         case 'a': // 1 string to match.
          if ((memcmp(Name.data().$add(4), $("udited_transfer"), 15) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_CFAuditedTransfer; // "cf_audited_transfer"
         case 'r': // 1 string to match.
          if ((memcmp(Name.data().$add(4), $("eturns_retained"), 15) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_CFReturnsRetained; // "cf_returns_retained"
         case 'u': // 1 string to match.
          if ((memcmp(Name.data().$add(4), $("nknown_transfer"), 15) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_CFUnknownTransfer; // "cf_unknown_transfer"
        }
        break;
       case 'n': // 2 strings to match.
        switch (Name.$at(1)) {
         default:
          break;
         case 'o': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("_sanitize_address"), 17) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_NoSanitizeSpecific; // "no_sanitize_address"
         case 's': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("_returns_retained"), 17) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_NSReturnsRetained; // "ns_returns_retained"
        }
        break;
       case 'o': // 3 strings to match.
        if ((memcmp(Name.data().$add(1), $("bjc_"), 4) != 0)) {
          break;
        }
        switch (Name.$at(5)) {
         default:
          break;
         case 'b': // 2 strings to match.
          if ((memcmp(Name.data().$add(6), $("ridge_"), 6) != 0)) {
            break;
          }
          switch (Name.$at(12)) {
           default:
            break;
           case 'm': // 1 string to match.
            if ((memcmp(Name.data().$add(13), $("utable"), 6) != 0)) {
              break;
            }
            return AttributeList.Kind.AT_ObjCBridgeMutable; // "objc_bridge_mutable"
           case 'r': // 1 string to match.
            if ((memcmp(Name.data().$add(13), $("elated"), 6) != 0)) {
              break;
            }
            return AttributeList.Kind.AT_ObjCBridgeRelated; // "objc_bridge_related"
          }
          break;
         case 'r': // 1 string to match.
          if ((memcmp(Name.data().$add(6), $("equires_super"), 13) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_ObjCRequiresSuper; // "objc_requires_super"
        }
        break;
       case 'r': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("equires_capability"), 18) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_RequiresCapability; // "requires_capability"
      }
      break;
     case 20: // 5 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case 'n': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("eon_polyvector_type"), 19) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_NeonPolyVectorType; // "neon_polyvector_type"
       case 'o': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("bjc_runtime_visible"), 19) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_ObjCRuntimeVisible; // "objc_runtime_visible"
       case 'r': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("eqd_work_group_size"), 19) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_ReqdWorkGroupSize; // "reqd_work_group_size"
       case 's': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("hared_lock_function"), 19) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_AcquireCapability; // "shared_lock_function"
       case 'w': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("ork_group_size_hint"), 19) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_WorkGroupSizeHint; // "work_group_size_hint"
      }
      break;
     case 21: // 7 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case 'a': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("ssert_exclusive_lock"), 20) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_AssertExclusiveLock; // "assert_exclusive_lock"
       case 'o': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("bjc_precise_lifetime"), 20) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_ObjCPreciseLifetime; // "objc_precise_lifetime"
       case 'p': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("ointer_with_type_tag"), 20) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_ArgumentWithTypeTag; // "pointer_with_type_tag"
       case 's': // 2 strings to match.
        switch (Name.$at(1)) {
         default:
          break;
         case 'h': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("ared_locks_required"), 19) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_RequiresCapability; // "shared_locks_required"
         case 'w': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("ift_indirect_result"), 19) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_SwiftIndirectResult; // "swift_indirect_result"
        }
        break;
       case 't': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("ype_tag_for_datatype"), 20) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_TypeTagForDatatype; // "type_tag_for_datatype"
       case 'x': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("ray_never_instrument"), 20) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_XRayInstrument; // "xray_never_instrument"
      }
      break;
     case 22: // 5 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case 'a': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("rgument_with_type_tag"), 21) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_ArgumentWithTypeTag; // "argument_with_type_tag"
       case 'n': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("o_instrument_function"), 21) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_NoInstrumentFunction; // "no_instrument_function"
       case 'o': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("bjc_independent_class"), 21) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_ObjCIndependentClass; // "objc_independent_class"
       case 't': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("ry_acquire_capability"), 21) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_TryAcquireCapability; // "try_acquire_capability"
       case 'x': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("ray_always_instrument"), 21) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_XRayInstrument; // "xray_always_instrument"
      }
      break;
     case 23: // 6 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case 'c': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("f_returns_not_retained"), 22) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_CFReturnsNotRetained; // "cf_returns_not_retained"
       case 'e': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("xclusive_lock_function"), 22) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_AcquireCapability; // "exclusive_lock_function"
       case 'f': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("orce_align_arg_pointer"), 22) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_X86ForceAlignArgPointer; // "force_align_arg_pointer"
       case 'n': // 2 strings to match.
        if ((memcmp(Name.data().$add(1), $("s_returns_"), 10) != 0)) {
          break;
        }
        switch (Name.$at(11)) {
         default:
          break;
         case 'a': // 1 string to match.
          if ((memcmp(Name.data().$add(12), $("utoreleased"), 11) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_NSReturnsAutoreleased; // "ns_returns_autoreleased"
         case 'n': // 1 string to match.
          if ((memcmp(Name.data().$add(12), $("ot_retained"), 11) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_NSReturnsNotRetained; // "ns_returns_not_retained"
        }
        break;
       case 's': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("hared_trylock_function"), 22) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_SharedTrylockFunction; // "shared_trylock_function"
      }
      break;
     case 24: // 2 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case 'a': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("ssert_shared_capability"), 23) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_AssertCapability; // "assert_shared_capability"
       case 'e': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("xclusive_locks_required"), 23) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_RequiresCapability; // "exclusive_locks_required"
      }
      break;
     case 25: // 3 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case 'a': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("cquire_shared_capability"), 24) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_AcquireCapability; // "acquire_shared_capability"
       case 'n': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("o_thread_safety_analysis"), 24) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_NoThreadSafetyAnalysis; // "no_thread_safety_analysis"
       case 'r': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("elease_shared_capability"), 24) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_ReleaseCapability; // "release_shared_capability"
      }
      break;
     case 26: // 6 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case 'c': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("onsumable_auto_cast_state"), 25) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_ConsumableAutoCast; // "consumable_auto_cast_state"
       case 'e': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("xclusive_trylock_function"), 25) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_ExclusiveTrylockFunction; // "exclusive_trylock_function"
       case 'n': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("o_address_safety_analysis"), 25) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_NoSanitizeSpecific; // "no_address_safety_analysis"
       case 'o': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("bjc_returns_inner_pointer"), 25) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_ObjCReturnsInnerPointer; // "objc_returns_inner_pointer"
       case 'r': // 2 strings to match.
        if (Name.$at(1) != $$e) {
          break;
        }
        switch (Name.$at(2)) {
         default:
          break;
         case 'l': // 1 string to match.
          if ((memcmp(Name.data().$add(3), $("ease_generic_capability"), 23) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_ReleaseCapability; // "release_generic_capability"
         case 'q': // 1 string to match.
          if ((memcmp(Name.data().$add(3), $("uires_shared_capability"), 23) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_RequiresCapability; // "requires_shared_capability"
        }
        break;
      }
      break;
     case 27: // 3 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case 'd': // 2 strings to match.
        if ((memcmp(Name.data().$add(1), $("evice_builtin_"), 14) != 0)) {
          break;
        }
        switch (Name.$at(15)) {
         default:
          break;
         case 's': // 1 string to match.
          if ((memcmp(Name.data().$add(16), $("urface_type"), 11) != 0)) {
            break;
          }
          return AttributeList.Kind.IgnoredAttribute; // "device_builtin_surface_type"
         case 't': // 1 string to match.
          if ((memcmp(Name.data().$add(16), $("exture_type"), 11) != 0)) {
            break;
          }
          return AttributeList.Kind.IgnoredAttribute; // "device_builtin_texture_type"
        }
        break;
       case 'o': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("bjc_designated_initializer"), 26) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_ObjCDesignatedInitializer; // "objc_designated_initializer"
      }
      break;
     case 28: // 1 string to match.
      if ((memcmp(Name.data().$add(0), $("consumable_set_state_on_read"), 28) != 0)) {
        break;
      }
      return AttributeList.Kind.AT_ConsumableSetOnRead; // "consumable_set_state_on_read"
     case 29: // 1 string to match.
      if ((memcmp(Name.data().$add(0), $("try_acquire_shared_capability"), 29) != 0)) {
        break;
      }
      return AttributeList.Kind.AT_TryAcquireCapability; // "try_acquire_shared_capability"
     case 34: // 1 string to match.
      if ((memcmp(Name.data().$add(0), $("objc_requires_property_definitions"), 34) != 0)) {
        break;
      }
      return AttributeList.Kind.AT_ObjCRequiresPropertyDefs; // "objc_requires_property_definitions"
     case 35: // 1 string to match.
      if ((memcmp(Name.data().$add(0), $("objc_arc_weak_reference_unavailable"), 35) != 0)) {
        break;
      }
      return AttributeList.Kind.AT_ArcWeakrefUnavailable; // "objc_arc_weak_reference_unavailable"
     case 46: // 1 string to match.
      if ((memcmp(Name.data().$add(0), $("objc_protocol_requires_explicit_implementation"), 46) != 0)) {
        break;
      }
      return AttributeList.Kind.AT_ObjCExplicitProtocolImpl; // "objc_protocol_requires_explicit_implementation"
    }
  } else if (AttributeList.Syntax.AS_Declspec == Syntax) {
    switch (Name.size()) {
     default:
      break;
     case 4: // 1 string to match.
      if ((memcmp(Name.data().$add(0), $("uuid"), 4) != 0)) {
        break;
      }
      return AttributeList.Kind.AT_Uuid; // "uuid"
     case 5: // 2 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case 'a': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("lign"), 4) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_Aligned; // "align"
       case 'n': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("aked"), 4) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_Naked; // "naked"
      }
      break;
     case 6: // 1 string to match.
      if ((memcmp(Name.data().$add(0), $("thread"), 6) != 0)) {
        break;
      }
      return AttributeList.Kind.AT_Thread; // "thread"
     case 7: // 2 strings to match.
      if ((memcmp(Name.data().$add(0), $("no"), 2) != 0)) {
        break;
      }
      switch (Name.$at(2)) {
       default:
        break;
       case 'a': // 1 string to match.
        if ((memcmp(Name.data().$add(3), $("lias"), 4) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_NoAlias; // "noalias"
       case 't': // 1 string to match.
        if ((memcmp(Name.data().$add(3), $("hrow"), 4) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_NoThrow; // "nothrow"
      }
      break;
     case 8: // 6 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case 'a': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("llocate"), 7) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_Section; // "allocate"
       case 'n': // 3 strings to match.
        if (Name.$at(1) != $$o) {
          break;
        }
        switch (Name.$at(2)) {
         default:
          break;
         case 'i': // 1 string to match.
          if ((memcmp(Name.data().$add(3), $("nline"), 5) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_NoInline; // "noinline"
         case 'r': // 1 string to match.
          if ((memcmp(Name.data().$add(3), $("eturn"), 5) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_NoReturn; // "noreturn"
         case 'v': // 1 string to match.
          if ((memcmp(Name.data().$add(3), $("table"), 5) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_MSNoVTable; // "novtable"
        }
        break;
       case 'p': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("roperty"), 7) != 0)) {
          break;
        }
        return AttributeList.Kind.IgnoredAttribute; // "property"
       case 'r': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("estrict"), 7) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_Restrict; // "restrict"
      }
      break;
     case 9: // 3 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case 'd': // 2 strings to match.
        if ((memcmp(Name.data().$add(1), $ll, 2) != 0)) {
          break;
        }
        switch (Name.$at(3)) {
         default:
          break;
         case 'e': // 1 string to match.
          if ((memcmp(Name.data().$add(4), $("xport"), 5) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_DLLExport; // "dllexport"
         case 'i': // 1 string to match.
          if ((memcmp(Name.data().$add(4), $("mport"), 5) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_DLLImport; // "dllimport"
        }
        break;
       case 's': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("electany"), 8) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_SelectAny; // "selectany"
      }
      break;
     case 10: // 1 string to match.
      if ((memcmp(Name.data().$add(0), $("deprecated"), 10) != 0)) {
        break;
      }
      return AttributeList.Kind.AT_Deprecated; // "deprecated"
     case 11: // 1 string to match.
      if ((memcmp(Name.data().$add(0), $("empty_bases"), 11) != 0)) {
        break;
      }
      return AttributeList.Kind.AT_EmptyBases; // "empty_bases"
     case 14: // 1 string to match.
      if ((memcmp(Name.data().$add(0), $("layout_version"), 14) != 0)) {
        break;
      }
      return AttributeList.Kind.AT_LayoutVersion; // "layout_version"
    }
  } else if (AttributeList.Syntax.AS_CXX11 == Syntax) {
    switch (Name.size()) {
     default:
      break;
     case 8: // 2 strings to match.
      if ((memcmp(Name.data().$add(0), $("gnu::"), 5) != 0)) {
        break;
      }
      switch (Name.$at(5)) {
       default:
        break;
       case 'h': // 1 string to match.
        if ((memcmp(Name.data().$add(6), $("ot"), 2) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_Hot; // "gnu::hot"
       case 'p': // 1 string to match.
        if ((memcmp(Name.data().$add(6), $("cs"), 2) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_Pcs; // "gnu::pcs"
      }
      break;
     case 9: // 5 strings to match.
      if ((memcmp(Name.data().$add(0), $("gnu::"), 5) != 0)) {
        break;
      }
      switch (Name.$at(5)) {
       default:
        break;
       case 'c': // 1 string to match.
        if ((memcmp(Name.data().$add(6), $("old"), 3) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_Cold; // "gnu::cold"
       case 'm': // 1 string to match.
        if ((memcmp(Name.data().$add(6), $("ode"), 3) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_Mode; // "gnu::mode"
       case 'p': // 1 string to match.
        if ((memcmp(Name.data().$add(6), $("ure"), 3) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_Pure; // "gnu::pure"
       case 'u': // 1 string to match.
        if ((memcmp(Name.data().$add(6), $("sed"), 3) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_Used; // "gnu::used"
       case 'w': // 1 string to match.
        if ((memcmp(Name.data().$add(6), $("eak"), 3) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_Weak; // "gnu::weak"
      }
      break;
     case 10: // 6 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case ':': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $(":noreturn"), 9) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_CXX11NoReturn; // "::noreturn"
       case 'g': // 5 strings to match.
        if ((memcmp(Name.data().$add(1), $("nu::"), 4) != 0)) {
          break;
        }
        switch (Name.$at(5)) {
         default:
          break;
         case 'a': // 1 string to match.
          if ((memcmp(Name.data().$add(6), $("lias"), 4) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_Alias; // "gnu::alias"
         case 'c': // 2 strings to match.
          switch (Name.$at(6)) {
           default:
            break;
           case 'd': // 1 string to match.
            if ((memcmp(Name.data().$add(7), $("ecl"), 3) != 0)) {
              break;
            }
            return AttributeList.Kind.AT_CDecl; // "gnu::cdecl"
           case 'o': // 1 string to match.
            if ((memcmp(Name.data().$add(7), $("nst"), 3) != 0)) {
              break;
            }
            return AttributeList.Kind.AT_Const; // "gnu::const"
          }
          break;
         case 'i': // 1 string to match.
          if ((memcmp(Name.data().$add(6), $("func"), 4) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_IFunc; // "gnu::ifunc"
         case 'n': // 1 string to match.
          if ((memcmp(Name.data().$add(6), $("aked"), 4) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_Naked; // "gnu::naked"
        }
        break;
      }
      break;
     case 11: // 9 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case ':': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $(":nodiscard"), 10) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_WarnUnusedResult; // "::nodiscard"
       case 'g': // 8 strings to match.
        if ((memcmp(Name.data().$add(1), $("nu::"), 4) != 0)) {
          break;
        }
        switch (Name.$at(5)) {
         default:
          break;
         case 'c': // 1 string to match.
          if ((memcmp(Name.data().$add(6), $("ommon"), 5) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_Common; // "gnu::common"
         case 'f': // 1 string to match.
          if ((memcmp(Name.data().$add(6), $("ormat"), 5) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_Format; // "gnu::format"
         case 'm': // 3 strings to match.
          switch (Name.$at(6)) {
           default:
            break;
           case 'a': // 1 string to match.
            if ((memcmp(Name.data().$add(7), $("lloc"), 4) != 0)) {
              break;
            }
            return AttributeList.Kind.AT_Restrict; // "gnu::malloc"
           case 'i': // 1 string to match.
            if ((memcmp(Name.data().$add(7), $("ps16"), 4) != 0)) {
              break;
            }
            return AttributeList.Kind.AT_Mips16; // "gnu::mips16"
           case 's': // 1 string to match.
            if ((memcmp(Name.data().$add(7), $("_abi"), 4) != 0)) {
              break;
            }
            return AttributeList.Kind.AT_MSABI; // "gnu::ms_abi"
          }
          break;
         case 'p': // 1 string to match.
          if ((memcmp(Name.data().$add(6), $("acked"), 5) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_Packed; // "gnu::packed"
         case 't': // 1 string to match.
          if ((memcmp(Name.data().$add(6), $("arget"), 5) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_Target; // "gnu::target"
         case 'u': // 1 string to match.
          if ((memcmp(Name.data().$add(6), $("nused"), 5) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_Unused; // "gnu::unused"
        }
        break;
      }
      break;
     case 12: // 13 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case ':': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $(":deprecated"), 11) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_Deprecated; // "::deprecated"
       case 'g': // 12 strings to match.
        if ((memcmp(Name.data().$add(1), $("nu::"), 4) != 0)) {
          break;
        }
        switch (Name.$at(5)) {
         default:
          break;
         case '_': // 1 string to match.
          if ((memcmp(Name.data().$add(6), $("_const"), 6) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_Const; // "gnu::__const"
         case 'a': // 2 strings to match.
          switch (Name.$at(6)) {
           default:
            break;
           case 'b': // 1 string to match.
            if ((memcmp(Name.data().$add(7), $("i_tag"), 5) != 0)) {
              break;
            }
            return AttributeList.Kind.AT_AbiTag; // "gnu::abi_tag"
           case 'l': // 1 string to match.
            if ((memcmp(Name.data().$add(7), $("igned"), 5) != 0)) {
              break;
            }
            return AttributeList.Kind.AT_Aligned; // "gnu::aligned"
          }
          break;
         case 'c': // 1 string to match.
          if ((memcmp(Name.data().$add(6), $("leanup"), 6) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_Cleanup; // "gnu::cleanup"
         case 'f': // 1 string to match.
          if ((memcmp(Name.data().$add(6), $("latten"), 6) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_Flatten; // "gnu::flatten"
         case 'n': // 3 strings to match.
          if (Name.$at(6) != $$o) {
            break;
          }
          switch (Name.$at(7)) {
           default:
            break;
           case 'd': // 1 string to match.
            if ((memcmp(Name.data().$add(8), $("ebug"), 4) != 0)) {
              break;
            }
            return AttributeList.Kind.AT_NoDebug; // "gnu::nodebug"
           case 'n': // 1 string to match.
            if ((memcmp(Name.data().$add(8), $("null"), 4) != 0)) {
              break;
            }
            return AttributeList.Kind.AT_NonNull; // "gnu::nonnull"
           case 't': // 1 string to match.
            if ((memcmp(Name.data().$add(8), $("hrow"), 4) != 0)) {
              break;
            }
            return AttributeList.Kind.AT_NoThrow; // "gnu::nothrow"
          }
          break;
         case 'r': // 1 string to match.
          if ((memcmp(Name.data().$add(6), $("egparm"), 6) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_Regparm; // "gnu::regparm"
         case 's': // 2 strings to match.
          switch (Name.$at(6)) {
           default:
            break;
           case 'e': // 1 string to match.
            if ((memcmp(Name.data().$add(7), $("ction"), 5) != 0)) {
              break;
            }
            return AttributeList.Kind.AT_Section; // "gnu::section"
           case 't': // 1 string to match.
            if ((memcmp(Name.data().$add(7), $("dcall"), 5) != 0)) {
              break;
            }
            return AttributeList.Kind.AT_StdCall; // "gnu::stdcall"
          }
          break;
         case 'w': // 1 string to match.
          if ((memcmp(Name.data().$add(6), $("eakref"), 6) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_WeakRef; // "gnu::weakref"
        }
        break;
      }
      break;
     case 13: // 9 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case ':': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $(":fallthrough"), 12) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_FallThrough; // "::fallthrough"
       case 'g': // 8 strings to match.
        if ((memcmp(Name.data().$add(1), $("nu::"), 4) != 0)) {
          break;
        }
        switch (Name.$at(5)) {
         default:
          break;
         case 'f': // 1 string to match.
          if ((memcmp(Name.data().$add(6), $("astcall"), 7) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_FastCall; // "gnu::fastcall"
         case 'n': // 4 strings to match.
          if (Name.$at(6) != $$o) {
            break;
          }
          switch (Name.$at(7)) {
           default:
            break;
           case 'c': // 1 string to match.
            if ((memcmp(Name.data().$add(8), $("ommon"), 5) != 0)) {
              break;
            }
            return AttributeList.Kind.AT_NoCommon; // "gnu::nocommon"
           case 'i': // 1 string to match.
            if ((memcmp(Name.data().$add(8), $("nline"), 5) != 0)) {
              break;
            }
            return AttributeList.Kind.AT_NoInline; // "gnu::noinline"
           case 'm': // 1 string to match.
            if ((memcmp(Name.data().$add(8), $("ips16"), 5) != 0)) {
              break;
            }
            return AttributeList.Kind.AT_NoMips16; // "gnu::nomips16"
           case 'r': // 1 string to match.
            if ((memcmp(Name.data().$add(8), $("eturn"), 5) != 0)) {
              break;
            }
            return AttributeList.Kind.AT_NoReturn; // "gnu::noreturn"
          }
          break;
         case 's': // 2 strings to match.
          switch (Name.$at(6)) {
           default:
            break;
           case 'e': // 1 string to match.
            if ((memcmp(Name.data().$add(7), $("ntinel"), 6) != 0)) {
              break;
            }
            return AttributeList.Kind.AT_Sentinel; // "gnu::sentinel"
           case 'y': // 1 string to match.
            if ((memcmp(Name.data().$add(7), $("sv_abi"), 6) != 0)) {
              break;
            }
            return AttributeList.Kind.AT_SysVABI; // "gnu::sysv_abi"
          }
          break;
         case 't': // 1 string to match.
          if ((memcmp(Name.data().$add(6), $("hiscall"), 7) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_ThisCall; // "gnu::thiscall"
        }
        break;
      }
      break;
     case 14: // 8 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case ':': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $(":maybe_unused"), 13) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_Unused; // "::maybe_unused"
       case 'c': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("lang::optnone"), 13) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_OptimizeNone; // "clang::optnone"
       case 'g': // 6 strings to match.
        if ((memcmp(Name.data().$add(1), $("nu::"), 4) != 0)) {
          break;
        }
        switch (Name.$at(5)) {
         default:
          break;
         case 'd': // 2 strings to match.
          if ((memcmp(Name.data().$add(6), $ll, 2) != 0)) {
            break;
          }
          switch (Name.$at(8)) {
           default:
            break;
           case 'e': // 1 string to match.
            if ((memcmp(Name.data().$add(9), $("xport"), 5) != 0)) {
              break;
            }
            return AttributeList.Kind.AT_DLLExport; // "gnu::dllexport"
           case 'i': // 1 string to match.
            if ((memcmp(Name.data().$add(9), $("mport"), 5) != 0)) {
              break;
            }
            return AttributeList.Kind.AT_DLLImport; // "gnu::dllimport"
          }
          break;
         case 'm': // 2 strings to match.
          switch (Name.$at(6)) {
           default:
            break;
           case 'a': // 1 string to match.
            if ((memcmp(Name.data().$add(7), $("y_alias"), 7) != 0)) {
              break;
            }
            return AttributeList.Kind.AT_MayAlias; // "gnu::may_alias"
           case 's': // 1 string to match.
            if ((memcmp(Name.data().$add(7), $("_struct"), 7) != 0)) {
              break;
            }
            return AttributeList.Kind.AT_MSStruct; // "gnu::ms_struct"
          }
          break;
         case 's': // 1 string to match.
          if ((memcmp(Name.data().$add(6), $("wiftcall"), 8) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_SwiftCall; // "gnu::swiftcall"
         case 't': // 1 string to match.
          if ((memcmp(Name.data().$add(6), $("ls_model"), 8) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_TLSModel; // "gnu::tls_model"
        }
        break;
      }
      break;
     case 15: // 5 strings to match.
      if ((memcmp(Name.data().$add(0), $("gnu::"), 5) != 0)) {
        break;
      }
      switch (Name.$at(5)) {
       default:
        break;
       case 'd': // 2 strings to match.
        if (Name.$at(6) != $$e) {
          break;
        }
        switch (Name.$at(7)) {
         default:
          break;
         case 'p': // 1 string to match.
          if ((memcmp(Name.data().$add(8), $("recated"), 7) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_Deprecated; // "gnu::deprecated"
         case 's': // 1 string to match.
          if ((memcmp(Name.data().$add(8), $("tructor"), 7) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_Destructor; // "gnu::destructor"
        }
        break;
       case 'f': // 1 string to match.
        if ((memcmp(Name.data().$add(6), $("ormat_arg"), 9) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_FormatArg; // "gnu::format_arg"
       case 'g': // 1 string to match.
        if ((memcmp(Name.data().$add(6), $("nu_inline"), 9) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_GNUInline; // "gnu::gnu_inline"
       case 'v': // 1 string to match.
        if ((memcmp(Name.data().$add(6), $("isibility"), 9) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_Visibility; // "gnu::visibility"
      }
      break;
     case 16: // 2 strings to match.
      if ((memcmp(Name.data().$add(0), $("gnu::"), 5) != 0)) {
        break;
      }
      switch (Name.$at(5)) {
       default:
        break;
       case 'c': // 1 string to match.
        if ((memcmp(Name.data().$add(6), $("onstructor"), 10) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_Constructor; // "gnu::constructor"
       case 'v': // 1 string to match.
        if ((memcmp(Name.data().$add(6), $("ector_size"), 10) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_VectorSize; // "gnu::vector_size"
      }
      break;
     case 17: // 1 string to match.
      if ((memcmp(Name.data().$add(0), $("clang::capability"), 17) != 0)) {
        break;
      }
      return AttributeList.Kind.AT_Capability; // "clang::capability"
     case 18: // 6 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case 'c': // 3 strings to match.
        if ((memcmp(Name.data().$add(1), $("lang::"), 6) != 0)) {
          break;
        }
        switch (Name.$at(7)) {
         default:
          break;
         case 'f': // 1 string to match.
          if ((memcmp(Name.data().$add(8), $("allthrough"), 10) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_FallThrough; // "clang::fallthrough"
         case 'n': // 2 strings to match.
          if (Name.$at(8) != $$o) {
            break;
          }
          switch (Name.$at(9)) {
           default:
            break;
           case '_': // 1 string to match.
            if ((memcmp(Name.data().$add(10), $("sanitize"), 8) != 0)) {
              break;
            }
            return AttributeList.Kind.AT_NoSanitize; // "clang::no_sanitize"
           case 'd': // 1 string to match.
            if ((memcmp(Name.data().$add(10), $("uplicate"), 8) != 0)) {
              break;
            }
            return AttributeList.Kind.AT_NoDuplicate; // "clang::noduplicate"
          }
          break;
        }
        break;
       case 'g': // 3 strings to match.
        if ((memcmp(Name.data().$add(1), $("nu::"), 4) != 0)) {
          break;
        }
        switch (Name.$at(5)) {
         default:
          break;
         case 'a': // 1 string to match.
          if ((memcmp(Name.data().$add(6), $("lways_inline"), 12) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_AlwaysInline; // "gnu::always_inline"
         case 'r': // 1 string to match.
          if ((memcmp(Name.data().$add(6), $("eturns_twice"), 12) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_ReturnsTwice; // "gnu::returns_twice"
         case 's': // 1 string to match.
          if ((memcmp(Name.data().$add(6), $("wift_context"), 12) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_SwiftContext; // "gnu::swift_context"
        }
        break;
      }
      break;
     case 19: // 2 strings to match.
      if ((memcmp(Name.data().$add(0), $("gnu::"), 5) != 0)) {
        break;
      }
      switch (Name.$at(5)) {
       default:
        break;
       case 'a': // 1 string to match.
        if ((memcmp(Name.data().$add(6), $("ssume_aligned"), 13) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_AssumeAligned; // "gnu::assume_aligned"
       case 'n': // 1 string to match.
        if ((memcmp(Name.data().$add(6), $("o_split_stack"), 13) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_NoSplitStack; // "gnu::no_split_stack"
      }
      break;
     case 20: // 2 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case ':': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $(":carries_dependency"), 19) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_CarriesDependency; // "::carries_dependency"
       case 'g': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("nu::returns_nonnull"), 19) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_ReturnsNonNull; // "gnu::returns_nonnull"
      }
      break;
     case 22: // 3 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case 'c': // 2 strings to match.
        if ((memcmp(Name.data().$add(1), $("lang::"), 6) != 0)) {
          break;
        }
        switch (Name.$at(7)) {
         default:
          break;
         case 'n': // 1 string to match.
          if ((memcmp(Name.data().$add(8), $("ot_tail_called"), 14) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_NotTailCalled; // "clang::not_tail_called"
         case 't': // 1 string to match.
          if ((memcmp(Name.data().$add(8), $("ype_visibility"), 14) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_TypeVisibility; // "clang::type_visibility"
        }
        break;
       case 'g': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("nu::transparent_union"), 21) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_TransparentUnion; // "gnu::transparent_union"
      }
      break;
     case 23: // 4 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case 'c': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("lang::internal_linkage"), 22) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_InternalLinkage; // "clang::internal_linkage"
       case 'g': // 3 strings to match.
        if ((memcmp(Name.data().$add(1), $("nu::"), 4) != 0)) {
          break;
        }
        switch (Name.$at(5)) {
         default:
          break;
         case 'n': // 1 string to match.
          if ((memcmp(Name.data().$add(6), $("o_sanitize_thread"), 17) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_NoSanitizeSpecific; // "gnu::no_sanitize_thread"
         case 's': // 1 string to match.
          if ((memcmp(Name.data().$add(6), $("wift_error_result"), 17) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_SwiftErrorResult; // "gnu::swift_error_result"
         case 'w': // 1 string to match.
          if ((memcmp(Name.data().$add(6), $("arn_unused_result"), 17) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_WarnUnusedResult; // "gnu::warn_unused_result"
        }
        break;
      }
      break;
     case 24: // 3 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case 'c': // 2 strings to match.
        if ((memcmp(Name.data().$add(1), $("lang::"), 6) != 0)) {
          break;
        }
        switch (Name.$at(7)) {
         default:
          break;
         case 'a': // 1 string to match.
          if ((memcmp(Name.data().$add(8), $("ssert_capability"), 16) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_AssertCapability; // "clang::assert_capability"
         case 's': // 1 string to match.
          if ((memcmp(Name.data().$add(8), $("hared_capability"), 16) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_Capability; // "clang::shared_capability"
        }
        break;
       case 'g': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("nu::no_sanitize_address"), 23) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_NoSanitizeSpecific; // "gnu::no_sanitize_address"
      }
      break;
     case 25: // 4 strings to match.
      if ((memcmp(Name.data().$add(0), $("clang::"), 7) != 0)) {
        break;
      }
      switch (Name.$at(7)) {
       default:
        break;
       case 'a': // 1 string to match.
        if ((memcmp(Name.data().$add(8), $("cquire_capability"), 17) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_AcquireCapability; // "clang::acquire_capability"
       case 'd': // 1 string to match.
        if ((memcmp(Name.data().$add(8), $("isable_tail_calls"), 17) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_DisableTailCalls; // "clang::disable_tail_calls"
       case 'r': // 1 string to match.
        if ((memcmp(Name.data().$add(8), $("elease_capability"), 17) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_ReleaseCapability; // "clang::release_capability"
       case 'w': // 1 string to match.
        if ((memcmp(Name.data().$add(8), $("arn_unused_result"), 17) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_WarnUnusedResult; // "clang::warn_unused_result"
      }
      break;
     case 26: // 2 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case 'c': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("lang::requires_capability"), 25) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_RequiresCapability; // "clang::requires_capability"
       case 'g': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("nu::swift_indirect_result"), 25) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_SwiftIndirectResult; // "gnu::swift_indirect_result"
      }
      break;
     case 27: // 1 string to match.
      if ((memcmp(Name.data().$add(0), $("gnu::no_instrument_function"), 27) != 0)) {
        break;
      }
      return AttributeList.Kind.AT_NoInstrumentFunction; // "gnu::no_instrument_function"
     case 28: // 2 strings to match.
      if ((memcmp(Name.data().$add(0), $("clang::"), 7) != 0)) {
        break;
      }
      switch (Name.$at(7)) {
       default:
        break;
       case 'l': // 1 string to match.
        if ((memcmp(Name.data().$add(8), $("to_visibility_public"), 20) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_LTOVisibilityPublic; // "clang::lto_visibility_public"
       case 'x': // 1 string to match.
        if ((memcmp(Name.data().$add(8), $("ray_never_instrument"), 20) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_XRayInstrument; // "clang::xray_never_instrument"
      }
      break;
     case 29: // 2 strings to match.
      if ((memcmp(Name.data().$add(0), $("clang::"), 7) != 0)) {
        break;
      }
      switch (Name.$at(7)) {
       default:
        break;
       case 't': // 1 string to match.
        if ((memcmp(Name.data().$add(8), $("ry_acquire_capability"), 21) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_TryAcquireCapability; // "clang::try_acquire_capability"
       case 'x': // 1 string to match.
        if ((memcmp(Name.data().$add(8), $("ray_always_instrument"), 21) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_XRayInstrument; // "clang::xray_always_instrument"
      }
      break;
     case 31: // 2 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case 'c': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("lang::assert_shared_capability"), 30) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_AssertCapability; // "clang::assert_shared_capability"
       case 'g': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("nu::no_address_safety_analysis"), 30) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_NoSanitizeSpecific; // "gnu::no_address_safety_analysis"
      }
      break;
     case 32: // 2 strings to match.
      if ((memcmp(Name.data().$add(0), $("clang::"), 7) != 0)) {
        break;
      }
      switch (Name.$at(7)) {
       default:
        break;
       case 'a': // 1 string to match.
        if ((memcmp(Name.data().$add(8), $("cquire_shared_capability"), 24) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_AcquireCapability; // "clang::acquire_shared_capability"
       case 'r': // 1 string to match.
        if ((memcmp(Name.data().$add(8), $("elease_shared_capability"), 24) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_ReleaseCapability; // "clang::release_shared_capability"
      }
      break;
     case 33: // 2 strings to match.
      if ((memcmp(Name.data().$add(0), $("clang::re"), 9) != 0)) {
        break;
      }
      switch (Name.$at(9)) {
       default:
        break;
       case 'l': // 1 string to match.
        if ((memcmp(Name.data().$add(10), $("ease_generic_capability"), 23) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_ReleaseCapability; // "clang::release_generic_capability"
       case 'q': // 1 string to match.
        if ((memcmp(Name.data().$add(10), $("uires_shared_capability"), 23) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_RequiresCapability; // "clang::requires_shared_capability"
      }
      break;
     case 36: // 1 string to match.
      if ((memcmp(Name.data().$add(0), $("clang::try_acquire_shared_capability"), 36) != 0)) {
        break;
      }
      return AttributeList.Kind.AT_TryAcquireCapability; // "clang::try_acquire_shared_capability"
    }
  } else if (AttributeList.Syntax.AS_Keyword == Syntax || AttributeList.Syntax.AS_ContextSensitiveKeyword == Syntax) {
    switch (Name.size()) {
     default:
      break;
     case 5: // 2 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case '_': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("_w64"), 4) != 0)) {
          break;
        }
        return AttributeList.Kind.IgnoredAttribute; // "__w64"
       case 'l': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("ocal"), 4) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_OpenCLLocalAddressSpace; // "local"
      }
      break;
     case 6: // 5 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case '_': // 3 strings to match.
        switch (Name.$at(1)) {
         default:
          break;
         case '_': // 2 strings to match.
          switch (Name.$at(2)) {
           default:
            break;
           case 's': // 1 string to match.
            if ((memcmp(Name.data().$add(3), $("ptr"), 3) != 0)) {
              break;
            }
            return AttributeList.Kind.AT_SPtr; // "__sptr"
           case 'u': // 1 string to match.
            if ((memcmp(Name.data().$add(3), $("ptr"), 3) != 0)) {
              break;
            }
            return AttributeList.Kind.AT_UPtr; // "__uptr"
          }
          break;
         case 'c': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("decl"), 4) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_CDecl; // "_cdecl"
        }
        break;
       case 'g': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("lobal"), 5) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_OpenCLGlobalAddressSpace; // "global"
       case 'k': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("ernel"), 5) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_OpenCLKernel; // "kernel"
      }
      break;
     case 7: // 8 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case '_': // 5 strings to match.
        switch (Name.$at(1)) {
         default:
          break;
         case '_': // 4 strings to match.
          switch (Name.$at(2)) {
           default:
            break;
           case 'c': // 1 string to match.
            if ((memcmp(Name.data().$add(3), $("decl"), 4) != 0)) {
              break;
            }
            return AttributeList.Kind.AT_CDecl; // "__cdecl"
           case 'l': // 1 string to match.
            if ((memcmp(Name.data().$add(3), $("ocal"), 4) != 0)) {
              break;
            }
            return AttributeList.Kind.AT_OpenCLLocalAddressSpace; // "__local"
           case 'p': // 2 strings to match.
            if ((memcmp(Name.data().$add(3), $("tr"), 2) != 0)) {
              break;
            }
            switch (Name.$at(5)) {
             default:
              break;
             case '3': // 1 string to match.
              if (Name.$at(6) != $$2) {
                break;
              }
              return AttributeList.Kind.AT_Ptr32; // "__ptr32"
             case '6': // 1 string to match.
              if (Name.$at(6) != $$4) {
                break;
              }
              return AttributeList.Kind.AT_Ptr64; // "__ptr64"
            }
            break;
          }
          break;
         case 'p': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("ascal"), 5) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_Pascal; // "_pascal"
        }
        break;
       case 'a': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("lignas"), 6) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_Aligned; // "alignas"
       case 'g': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("eneric"), 6) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_OpenCLGenericAddressSpace; // "generic"
       case 'p': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("rivate"), 6) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_OpenCLPrivateAddressSpace; // "private"
      }
      break;
     case 8: // 8 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case '_': // 7 strings to match.
        switch (Name.$at(1)) {
         default:
          break;
         case 'A': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("lignas"), 6) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_Aligned; // "_Alignas"
         case 'N': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("onnull"), 6) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_TypeNonNull; // "_Nonnull"
         case '_': // 4 strings to match.
          switch (Name.$at(2)) {
           default:
            break;
           case 'g': // 1 string to match.
            if ((memcmp(Name.data().$add(3), $("lobal"), 5) != 0)) {
              break;
            }
            return AttributeList.Kind.AT_OpenCLGlobalAddressSpace; // "__global"
           case 'k': // 2 strings to match.
            switch (Name.$at(3)) {
             default:
              break;
             case 'e': // 1 string to match.
              if ((memcmp(Name.data().$add(4), $("rnel"), 4) != 0)) {
                break;
              }
              return AttributeList.Kind.AT_OpenCLKernel; // "__kernel"
             case 'i': // 1 string to match.
              if ((memcmp(Name.data().$add(4), $("ndof"), 4) != 0)) {
                break;
              }
              return AttributeList.Kind.AT_ObjCKindOf; // "__kindof"
            }
            break;
           case 'p': // 1 string to match.
            if ((memcmp(Name.data().$add(3), $("ascal"), 5) != 0)) {
              break;
            }
            return AttributeList.Kind.AT_Pascal; // "__pascal"
          }
          break;
         case 's': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("tdcall"), 6) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_StdCall; // "_stdcall"
        }
        break;
       case 'c': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("onstant"), 7) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_OpenCLConstantAddressSpace; // "constant"
      }
      break;
     case 9: // 7 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case '_': // 6 strings to match.
        switch (Name.$at(1)) {
         default:
          break;
         case 'N': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("ullable"), 7) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_TypeNullable; // "_Nullable"
         case '_': // 3 strings to match.
          switch (Name.$at(2)) {
           default:
            break;
           case 'g': // 1 string to match.
            if ((memcmp(Name.data().$add(3), $("eneric"), 6) != 0)) {
              break;
            }
            return AttributeList.Kind.AT_OpenCLGenericAddressSpace; // "__generic"
           case 'p': // 1 string to match.
            if ((memcmp(Name.data().$add(3), $("rivate"), 6) != 0)) {
              break;
            }
            return AttributeList.Kind.AT_OpenCLPrivateAddressSpace; // "__private"
           case 's': // 1 string to match.
            if ((memcmp(Name.data().$add(3), $("tdcall"), 6) != 0)) {
              break;
            }
            return AttributeList.Kind.AT_StdCall; // "__stdcall"
          }
          break;
         case 'f': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("astcall"), 7) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_FastCall; // "_fastcall"
         case 't': // 1 string to match.
          if ((memcmp(Name.data().$add(2), $("hiscall"), 7) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_ThisCall; // "_thiscall"
        }
        break;
       case 'r': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("ead_only"), 8) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_OpenCLAccess; // "read_only"
      }
      break;
     case 10: // 5 strings to match.
      switch (Name.$at(0)) {
       default:
        break;
       case '_': // 3 strings to match.
        if (Name.$at(1) != $$UNDERSCORE) {
          break;
        }
        switch (Name.$at(2)) {
         default:
          break;
         case 'c': // 1 string to match.
          if ((memcmp(Name.data().$add(3), $("onstant"), 7) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_OpenCLConstantAddressSpace; // "__constant"
         case 'f': // 1 string to match.
          if ((memcmp(Name.data().$add(3), $("astcall"), 7) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_FastCall; // "__fastcall"
         case 't': // 1 string to match.
          if ((memcmp(Name.data().$add(3), $("hiscall"), 7) != 0)) {
            break;
          }
          return AttributeList.Kind.AT_ThisCall; // "__thiscall"
        }
        break;
       case 'r': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("ead_write"), 9) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_OpenCLAccess; // "read_write"
       case 'w': // 1 string to match.
        if ((memcmp(Name.data().$add(1), $("rite_only"), 9) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_OpenCLAccess; // "write_only"
      }
      break;
     case 11: // 2 strings to match.
      if (Name.$at(0) != $$UNDERSCORE) {
        break;
      }
      switch (Name.$at(1)) {
       default:
        break;
       case '_': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $read_only, 9) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_OpenCLAccess; // "__read_only"
       case 'v': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("ectorcall"), 9) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_VectorCall; // "_vectorcall"
      }
      break;
     case 12: // 3 strings to match.
      if ((memcmp(Name.data().$add(0), $("__"), 2) != 0)) {
        break;
      }
      switch (Name.$at(2)) {
       default:
        break;
       case 'r': // 1 string to match.
        if ((memcmp(Name.data().$add(3), $("ead_write"), 9) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_OpenCLAccess; // "__read_write"
       case 'v': // 1 string to match.
        if ((memcmp(Name.data().$add(3), $("ectorcall"), 9) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_VectorCall; // "__vectorcall"
       case 'w': // 1 string to match.
        if ((memcmp(Name.data().$add(3), $("rite_only"), 9) != 0)) {
          break;
        }
        return AttributeList.Kind.AT_OpenCLAccess; // "__write_only"
      }
      break;
     case 13: // 1 string to match.
      if ((memcmp(Name.data().$add(0), $__forceinline, 13) != 0)) {
        break;
      }
      return AttributeList.Kind.AT_AlwaysInline; // "__forceinline"
     case 17: // 1 string to match.
      if ((memcmp(Name.data().$add(0), $_Null_unspecified, 17) != 0)) {
        break;
      }
      return AttributeList.Kind.AT_TypeNullUnspecified; // "_Null_unspecified"
     case 20: // 1 string to match.
      if ((memcmp(Name.data().$add(0), $__single_inheritance, 20) != 0)) {
        break;
      }
      return AttributeList.Kind.AT_MSInheritance; // "__single_inheritance"
     case 21: // 1 string to match.
      if ((memcmp(Name.data().$add(0), $__virtual_inheritance, 21) != 0)) {
        break;
      }
      return AttributeList.Kind.AT_MSInheritance; // "__virtual_inheritance"
     case 22: // 1 string to match.
      if ((memcmp(Name.data().$add(0), $__multiple_inheritance, 22) != 0)) {
        break;
      }
      return AttributeList.Kind.AT_MSInheritance; // "__multiple_inheritance"
     case 25: // 1 string to match.
      if ((memcmp(Name.data().$add(0), $("__unspecified_inheritance"), 25) != 0)) {
        break;
      }
      return AttributeList.Kind.AT_MSInheritance; // "__unspecified_inheritance"
    }
  } else if (AttributeList.Syntax.AS_Pragma == Syntax) {
    switch (Name.size()) {
     default:
      break;
     case 4: // 1 string to match.
      if ((memcmp(Name.data().$add(0), $("loop"), 4) != 0)) {
        break;
      }
      return AttributeList.Kind.AT_LoopHint; // "loop"
     case 6: // 1 string to match.
      if ((memcmp(Name.data().$add(0), $("unroll"), 6) != 0)) {
        break;
      }
      return AttributeList.Kind.AT_LoopHint; // "unroll"
     case 8: // 1 string to match.
      if ((memcmp(Name.data().$add(0), $("nounroll"), 8) != 0)) {
        break;
      }
      return AttributeList.Kind.AT_LoopHint; // "nounroll"
    }
  }
  return AttributeList.Kind.UnknownAttribute;
}

} // END OF class AttrParsedAttrKindsGlobals
