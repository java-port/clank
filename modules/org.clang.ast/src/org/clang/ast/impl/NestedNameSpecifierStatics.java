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
package org.clang.ast.impl;

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Casts.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clang.basic.*;


//<editor-fold defaultstate="collapsed" desc="static type NestedNameSpecifierStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZN12_GLOBAL__N_111LoadPointerEPvj;_ZN12_GLOBAL__N_111SavePointerEPvRPcRjS3_;_ZN12_GLOBAL__N_118LoadSourceLocationEPvj;_ZN12_GLOBAL__N_118SaveSourceLocationEN5clang14SourceLocationERPcRjS4_;_ZN12_GLOBAL__N_16AppendEPcS0_RS0_RjS2_; -static-type=NestedNameSpecifierStatics -package=org.clang.ast.impl")
//</editor-fold>
public final class NestedNameSpecifierStatics {

/// \brief Load a (possibly unaligned) source location from a given address
/// and offset.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LoadSourceLocation">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp", line = 381,
 FQN="(anonymous namespace)::LoadSourceLocation", NM="_ZN12_GLOBAL__N_118LoadSourceLocationEPvj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZN12_GLOBAL__N_118LoadSourceLocationEPvj")
//</editor-fold>
public static SourceLocation LoadSourceLocation(type$ptr<?>/*void P*/ Data, /*uint*/int Offset) {
//  /*uint*/uint$ptr Raw = create_uint$ptr();
//  memcpy(/*AddrOf*/Raw, (reinterpret_cast(/*static_cast*/char$ptr/*char P*/ .class, (Data))).$add(Offset), $sizeof_UInt());
//  return SourceLocation.getFromRawEncoding(Raw.$star());
    return new SourceLocation((SourceLocation)Data.$at(Offset));
}


/// \brief Load a (possibly unaligned) pointer from a given address and
/// offset.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LoadPointer">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp", line = 389,
 FQN="(anonymous namespace)::LoadPointer", NM="_ZN12_GLOBAL__N_111LoadPointerEPvj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZN12_GLOBAL__N_111LoadPointerEPvj")
//</editor-fold>
public static Object/*void P*/ LoadPointer(type$ptr<?>/*void P*/ Data, /*uint*/int Offset) {
//  ulong$ptr/*void P*/ Result = create_ulong$null$ptr();
//  memcpy(Result, (reinterpret_cast(/*static_cast*/char$ptr/*char P*/ .class, (Data))).$add(Offset), $sizeof_ptr(/*Object */));
//  return Result;
    return $tryClone(Data.$at(Offset));
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Append">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp", line = 450,
 FQN="(anonymous namespace)::Append", NM="_ZN12_GLOBAL__N_16AppendEPcS0_RS0_RjS2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZN12_GLOBAL__N_16AppendEPcS0_RS0_RjS2_")
//</editor-fold>
public static void Append(type$ptr<?>/*char P*/ Start, abstract_iterator/*char P*/ End, final type$ref<type$ptr<?>>/*char P&*/ Buffer, final uint$ref/*uint &*/ BufferSize, 
      final uint$ref/*uint &*/ BufferCapacity) {
  if ($eq_ptr(Start, End)) {
    return;
  }
  if ($greater_uint(BufferSize.$deref() + (End.$sub(Start)), BufferCapacity.$deref())) {
    // Reallocate the buffer.
    /*uint*/int NewCapacity = std.max((/*uint*/int)((BufferCapacity.$deref() != 0) ? BufferCapacity.$deref() * 2 : (true ? 1 : $sizeof_ptr(/*Object */)) * 2), 
        (/*uint*/int)(BufferSize.$deref() + (End.$sub(Start))));
    type$ptr/*char P*/ NewBuffer = $tryClone((reinterpret_cast(/*static_cast*/type$ptr/*char P*/ .class, (malloc(NewCapacity)))));
    if ((BufferCapacity.$deref() != 0)) {
      memcpy(NewBuffer, Buffer.$deref(), BufferSize.$deref(), true);
      free(Buffer.$deref());
    }
    Buffer.$set(NewBuffer);
    BufferCapacity.$set(NewCapacity);
  }
  
  memcpy((type$ptr)Buffer.$deref().$add(BufferSize.$deref()), Start, End.$sub(Start), true);
  BufferSize.$set$addassign(End.$sub(Start));
}


/// \brief Save a source location to the given buffer.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SaveSourceLocation">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp", line = 474,
 FQN="(anonymous namespace)::SaveSourceLocation", NM="_ZN12_GLOBAL__N_118SaveSourceLocationEN5clang14SourceLocationERPcRjS4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZN12_GLOBAL__N_118SaveSourceLocationEN5clang14SourceLocationERPcRjS4_")
//</editor-fold>
public static void SaveSourceLocation(SourceLocation Loc, final type$ref<type$ptr<?>>/*char P&*/ Buffer, 
                  final uint$ref/*uint &*/ BufferSize, final uint$ref/*uint &*/ BufferCapacity) {
//  /*uint*/int Raw = Loc.getRawEncoding();
  type$ptr $Loc = create_type$ptr(new SourceLocation(Loc));
  Append(reinterpret_cast(type$ptr/*char P*/ .class, $AddrOf($Loc)), 
      reinterpret_cast(type$ptr/*char P*/ .class, $AddrOf($Loc)).$add(true ? 1 : $sizeof_UInt()), 
      Buffer, BufferSize, BufferCapacity);
}


/// \brief Save a pointer to the given buffer.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SavePointer">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp", line = 483,
 FQN="(anonymous namespace)::SavePointer", NM="_ZN12_GLOBAL__N_111SavePointerEPvRPcRjS3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZN12_GLOBAL__N_111SavePointerEPvRPcRjS3_")
//</editor-fold>
public static void SavePointer(Object/*void P*/ Ptr, final type$ref<type$ptr<?>>/*char P&*/ Buffer, final uint$ref/*uint &*/ BufferSize, 
           final uint$ref/*uint &*/ BufferCapacity) {
  type$ptr $Ptr = create_type$ptr($tryClone(Ptr));
  Append(reinterpret_cast(type$ptr/*char P*/ .class, $Ptr), 
      reinterpret_cast(type$ptr/*char P*/ .class, $Ptr).$add(true ? 1 : $sizeof_ptr(/*Object */)), 
      Buffer, BufferSize, BufferCapacity);
}

} // END OF class NestedNameSpecifierStatics
