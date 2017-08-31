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

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.clang.ast.*;

/// InheritanceHierarchyWriter - Helper class that writes out a
/// GraphViz file that diagrams the inheritance hierarchy starting at
/// a given C++ class type. Note that we do not use LLVM's
/// GraphWriter, because the interface does not permit us to properly
/// differentiate between uses of types as virtual bases
/// vs. non-virtual bases.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InheritanceHierarchyWriter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/InheritViz.cpp", line = 34,
 FQN="(anonymous namespace)::InheritanceHierarchyWriter", NM="_ZN12_GLOBAL__N_126InheritanceHierarchyWriterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/InheritViz.cpp -nm=_ZN12_GLOBAL__N_126InheritanceHierarchyWriterE")
//</editor-fold>
public class InheritanceHierarchyWriter implements Destructors.ClassWithDestructor {
  private final ASTContext /*&*/ Context;
  private final raw_ostream /*&*/ Out;
  private std.mapTypeInt<QualType> DirectBaseCount;
  private std.setType<QualType> KnownVirtualBases;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InheritanceHierarchyWriter::InheritanceHierarchyWriter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/InheritViz.cpp", line = 41,
   FQN="(anonymous namespace)::InheritanceHierarchyWriter::InheritanceHierarchyWriter", NM="_ZN12_GLOBAL__N_126InheritanceHierarchyWriterC1ERN5clang10ASTContextERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/InheritViz.cpp -nm=_ZN12_GLOBAL__N_126InheritanceHierarchyWriterC1ERN5clang10ASTContextERN4llvm11raw_ostreamE")
  //</editor-fold>
  public InheritanceHierarchyWriter(final ASTContext /*&*/ Context, final raw_ostream /*&*/ Out) {
    // : Context(Context), Out(Out), DirectBaseCount(), KnownVirtualBases() 
    //START JInit
    this./*&*/Context=/*&*/Context;
    this./*&*/Out=/*&*/Out;
    this.DirectBaseCount = new std.mapTypeInt<QualType>(new QualTypeOrdering());
    this.KnownVirtualBases = new std.setType<QualType>(new QualTypeOrdering());
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InheritanceHierarchyWriter::WriteGraph">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/InheritViz.cpp", line = 44,
   FQN="(anonymous namespace)::InheritanceHierarchyWriter::WriteGraph", NM="_ZN12_GLOBAL__N_126InheritanceHierarchyWriter10WriteGraphEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/InheritViz.cpp -nm=_ZN12_GLOBAL__N_126InheritanceHierarchyWriter10WriteGraphEN5clang8QualTypeE")
  //</editor-fold>
  public void WriteGraph(QualType Type) {
    Out.$out(/*KEEP_STR*/"digraph \"").$out(DOT.EscapeString(Type.getAsString())).$out(
        /*KEEP_STR*/"\" {\n"
    );
    WriteNode(new QualType(Type), false);
    Out.$out(/*KEEP_STR*/"}\n");
  }

/*protected:*/
  /// WriteNode - Write out the description of node in the inheritance
  /// diagram, which may be a base class or it may be the root node.
  // namespace
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InheritanceHierarchyWriter::WriteNode">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/InheritViz.cpp", line = 63,
   FQN="(anonymous namespace)::InheritanceHierarchyWriter::WriteNode", NM="_ZN12_GLOBAL__N_126InheritanceHierarchyWriter9WriteNodeEN5clang8QualTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/InheritViz.cpp -nm=_ZN12_GLOBAL__N_126InheritanceHierarchyWriter9WriteNodeEN5clang8QualTypeEb")
  //</editor-fold>
  protected void WriteNode(QualType Type, boolean FromVirtual) {
    QualType CanonType = Context.getCanonicalType(/*NO_COPY*/Type).$QualType();
    if (FromVirtual) {
      if (KnownVirtualBases.find(CanonType).$noteq(KnownVirtualBases.end())) {
        return;
      }
      
      // We haven't seen this virtual base before, so display it and
      // its bases.
      KnownVirtualBases.insert_T$C$R(CanonType);
    }
    
    // Declare the node itself.
    Out.$out(/*KEEP_STR*/"  ");
    WriteNodeReference(new QualType(Type), FromVirtual);
    
    // Give the node a label based on the name of the class.
    std.string TypeName = Type.getAsString();
    Out.$out(/*KEEP_STR*/" [ shape=\"box\", label=\"").$out(DOT.EscapeString(TypeName));
    
    // If the name of the class was a typedef or something different
    // from the "real" class name, show the real class name in
    // parentheses so we don't confuse ourselves.
    if ($noteq_string$C(TypeName, CanonType.getAsString())) {
      Out.$out(/*KEEP_STR*/"\\n(").$out(CanonType.getAsString()).$out(/*KEEP_STR*/$RPAREN);
    }
    
    // Finished describing the node.
    Out.$out(/*KEEP_STR*/" \"];\n");
    
    // Display the base classes.
    /*const*/ CXXRecordDecl /*P*/ Decl = ((/*static_cast*//*const*/ CXXRecordDecl /*P*/ )(Type.$arrow().getAs$RecordType().getDecl()));
    for (final /*const*/ CXXBaseSpecifier /*&*/ Base : Decl.bases$Const()) {
      QualType CanonBaseType = Context.getCanonicalType(Base.getType()).$QualType();
      
      // If this is not virtual inheritance, bump the direct base
      // count for the type.
      if (!Base.isVirtual()) {
        DirectBaseCount.ref$at(CanonBaseType).$set$preInc();
      }
      
      // Write out the node (if we need to).
      WriteNode(Base.getType(), Base.isVirtual());
      
      // Write out the edge.
      Out.$out(/*KEEP_STR*/"  ");
      WriteNodeReference(new QualType(Type), FromVirtual);
      Out.$out(/*KEEP_STR*/" -> ");
      WriteNodeReference(Base.getType(), Base.isVirtual());
      
      // Write out edge attributes to show the kind of inheritance.
      if (Base.isVirtual()) {
        Out.$out(/*KEEP_STR*/" [ style=\"dashed\" ]");
      }
      Out.$out(/*KEEP_STR*/$SEMI);
    }
  }

  
  /// WriteNodeReference - Write out a reference to the given node,
  /// using a unique identifier for each direct base and for the
  /// (only) virtual base.
  
  /// WriteNodeReference - Write out a reference to the given node,
  /// using a unique identifier for each direct base and for the
  /// (only) virtual base.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InheritanceHierarchyWriter::WriteNodeReference">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/InheritViz.cpp", line = 124,
   FQN="(anonymous namespace)::InheritanceHierarchyWriter::WriteNodeReference", NM="_ZN12_GLOBAL__N_126InheritanceHierarchyWriter18WriteNodeReferenceEN5clang8QualTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/InheritViz.cpp -nm=_ZN12_GLOBAL__N_126InheritanceHierarchyWriter18WriteNodeReferenceEN5clang8QualTypeEb")
  //</editor-fold>
  protected raw_ostream /*&*/ WriteNodeReference(QualType Type, 
                    boolean FromVirtual) {
    QualType CanonType = Context.getCanonicalType(/*NO_COPY*/Type).$QualType();
    
    Out.$out(/*KEEP_STR*/"Class_").$out(CanonType.getAsOpaquePtr());
    if (!FromVirtual) {
      Out.$out(/*KEEP_STR*/$UNDERSCORE).$out_int(DirectBaseCount.$at_T$C$R(CanonType));
    }
    return Out;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InheritanceHierarchyWriter::~InheritanceHierarchyWriter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/InheritViz.cpp", line = 34,
   FQN="(anonymous namespace)::InheritanceHierarchyWriter::~InheritanceHierarchyWriter", NM="_ZN12_GLOBAL__N_126InheritanceHierarchyWriterD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/InheritViz.cpp -nm=_ZN12_GLOBAL__N_126InheritanceHierarchyWriterD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    KnownVirtualBases.$destroy();
    DirectBaseCount.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Context=" + "[ASTContext]" // NOI18N
              + ", Out=" + Out // NOI18N
              + ", DirectBaseCount=" + DirectBaseCount // NOI18N
              + ", KnownVirtualBases=" + KnownVirtualBases; // NOI18N
  }
}
