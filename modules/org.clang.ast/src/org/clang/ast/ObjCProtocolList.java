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

package org.clang.ast;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import org.clang.basic.*;
import static org.clang.basic.SourceLocation.*;


/// \brief A list of Objective-C protocols, along with the source
/// locations at which they were referenced.
//<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolList">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 76,
 FQN="clang::ObjCProtocolList", NM="_ZN5clang16ObjCProtocolListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCProtocolListE")
//</editor-fold>
public class ObjCProtocolList extends /*public*/ ObjCList<ObjCProtocolDecl> {
  private type$ptr<SourceLocation> /*P*/ Locations;
  
  //JAVA: using ObjCList<ObjCProtocolDecl>::set;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolList::ObjCProtocolList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 82,
   FQN="clang::ObjCProtocolList::ObjCProtocolList", NM="_ZN5clang16ObjCProtocolListC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCProtocolListC1Ev")
  //</editor-fold>
  public ObjCProtocolList() {
    // : ObjCList<ObjCProtocolDecl>(), Locations(null) 
    //START JInit
    super();
    this.Locations = null;
    //END JInit
  }

  
  /*typedef const SourceLocation *loc_iterator*/
//  public final class loc_iterator extends /*const*/type$ptr<SourceLocation> /*P*/ { };
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolList::loc_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 85,
   FQN="clang::ObjCProtocolList::loc_begin", NM="_ZNK5clang16ObjCProtocolList9loc_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCProtocolList9loc_beginEv")
  //</editor-fold>
  public /*const*/type$ptr<SourceLocation> /*P*/ loc_begin() /*const*/ {
    return Locations;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolList::loc_end">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 86,
   FQN="clang::ObjCProtocolList::loc_end", NM="_ZNK5clang16ObjCProtocolList7loc_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCProtocolList7loc_endEv")
  //</editor-fold>
  public /*const*/type$ptr<SourceLocation> /*P*/ loc_end() /*const*/ {
    final int size = size();
    return size == 0 ? Locations : Locations.$add(size);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCProtocolList::set">
  @Converted(kind = Converted.Kind.MANUAL/*Allocate*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 37,
   FQN="clang::ObjCProtocolList::set", NM="_ZN5clang16ObjCProtocolList3setEPKPNS_16ObjCProtocolDeclEjPKNS_14SourceLocationERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCProtocolList3setEPKPNS_16ObjCProtocolDeclEjPKNS_14SourceLocationERNS_10ASTContextE")
  //</editor-fold>
  public void set(type$ptr<ObjCProtocolDecl /*P*/ /*const*/ /*P*/> InList, /*uint*/int Elts, 
     /*const*/type$ptr<SourceLocation> /*P*/ Locs, final ASTContext /*&*/ Ctx) {
    if (Elts == 0) {
      return;
    }
    
    // JAVA: ALLOC
    Locations = create_const_type$ptr(/*NEW_EXPR [operator new[]] NM=_ZnajRKN5clang10ASTContextEj*/
    /*new (Ctx)*/ /*FIXME 2: $array_new_uint_ASTContext$C_uint*/new$T(new SourceLocation [Elts], SourceLocation::new));
    memcpy(Locations, Locs, (true ? /*JAVA*/1 : $sizeof_SourceLocation()) * Elts, false);
    set(InList, Elts, Ctx);
  }

  
  @Override public String toString() {
    return "" + "Locations=" + Locations // NOI18N
              + super.toString(); // NOI18N
  }
}
