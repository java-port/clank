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
package org.llvm.linker.impl;

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
import org.llvm.support.Error;
import org.llvm.ir.*;
import static org.llvm.ir.java.IrRTTI.*;
import org.llvm.linker.*;;
import org.llvm.linker.java.*;
import org.llvm.linker.java.LinkerFunctionPointers.*;
import org.llvm.linker.impl.*;
import org.llvm.llvmc.*;
import org.llvm.transforms.utils.*;


//<editor-fold defaultstate="collapsed" desc="static type IRMoverStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZL12mergeTriplesRKN4llvm6TripleES2_;_ZL12triplesMatchRKN4llvm6TripleES2_;_ZL13forceRenamingPN4llvm11GlobalValueENS_9StringRefE;_ZL16getArrayElementsPKN4llvm8ConstantERNS_15SmallVectorImplIPS0_EE; -static-type=IRMoverStatics -package=org.llvm.linker.impl")
//</editor-fold>
public final class IRMoverStatics {


/// The LLVM SymbolTable class autorenames globals that conflict in the symbol
/// table. This is good for all clients except for us. Go through the trouble
/// to force this back.
//<editor-fold defaultstate="collapsed" desc="forceRenaming">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp", line = 507,
 FQN="forceRenaming", NM="_ZL13forceRenamingPN4llvm11GlobalValueENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZL13forceRenamingPN4llvm11GlobalValueENS_9StringRefE")
//</editor-fold>
public static void forceRenaming(GlobalValue /*P*/ GV, StringRef Name) {
  // If the global doesn't force its name or if it already has the right name,
  // there is nothing for us to do.
  if (GV.hasLocalLinkage() || $eq_StringRef(GV.getName(), /*NO_COPY*/Name)) {
    return;
  }
  
  Module /*P*/ M = GV.getParent();
  {
    
    // If there is a conflict, rename the conflict.
    GlobalValue /*P*/ ConflictGV = M.getNamedValue(new StringRef(Name));
    if ((ConflictGV != null)) {
      GV.takeName(ConflictGV);
      ConflictGV.setName(new Twine(Name)); // This will cause ConflictGV to get renamed
      assert ($noteq_StringRef(ConflictGV.getName(), /*NO_COPY*/Name)) : "forceRenaming didn't work";
    } else {
      GV.setName(new Twine(Name)); // Force the name back
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="getArrayElements">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp", line = 735,
 FQN="getArrayElements", NM="_ZL16getArrayElementsPKN4llvm8ConstantERNS_15SmallVectorImplIPS0_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZL16getArrayElementsPKN4llvm8ConstantERNS_15SmallVectorImplIPS0_EE")
//</editor-fold>
public static void getArrayElements(/*const*/ Constant /*P*/ C, 
                final SmallVectorImpl<Constant /*P*/ > /*&*/ Dest) {
  /*uint*/int NumElements = $ulong2uint(cast_ArrayType(C.getType()).getNumElements());
  
  for (/*uint*/int i = 0; i != NumElements; ++i)  {
    Dest.push_back(C.getAggregateElement(i));
  }
}


// This function returns true if the triples match.
//<editor-fold defaultstate="collapsed" desc="triplesMatch">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp", line = 1163,
 FQN="triplesMatch", NM="_ZL12triplesMatchRKN4llvm6TripleES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZL12triplesMatchRKN4llvm6TripleES2_")
//</editor-fold>
public static boolean triplesMatch(final /*const*/ Triple /*&*/ T0, final /*const*/ Triple /*&*/ T1) {
  // If vendor is apple, ignore the version number.
  if (T0.getVendor() == Triple.VendorType.Apple) {
    return T0.getArch() == T1.getArch() && T0.getSubArch() == T1.getSubArch()
       && T0.getVendor() == T1.getVendor() && T0.getOS() == T1.getOS();
  }
  
  return T0.$eq(T1);
}


// This function returns the merged triple.
//<editor-fold defaultstate="collapsed" desc="mergeTriples">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp", line = 1173,
 FQN="mergeTriples", NM="_ZL12mergeTriplesRKN4llvm6TripleES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZL12mergeTriplesRKN4llvm6TripleES2_")
//</editor-fold>
public static std.string mergeTriples(final /*const*/ Triple /*&*/ SrcTriple, 
            final /*const*/ Triple /*&*/ DstTriple) {
  // If vendor is apple, pick the triple with the larger version number.
  if (SrcTriple.getVendor() == Triple.VendorType.Apple) {
    if (DstTriple.isOSVersionLT(SrcTriple)) {
      return new std.string(SrcTriple.str());
    }
  }
  
  return new std.string(DstTriple.str());
}

} // END OF class IRMoverStatics
